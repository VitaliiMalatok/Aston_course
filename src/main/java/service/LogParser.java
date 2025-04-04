package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogParser {
    private static final Logger LOGGER = LogManager.getLogger(LogParser.class);

    public static String getLatestLogFile(String directoryPath) {
        try {
            return Files.list(Paths.get(directoryPath))
                    .filter(Files::isRegularFile)
                    .max((f1, f2) -> {
                        try {
                            return Files.getLastModifiedTime(f1).compareTo(Files.getLastModifiedTime(f2));
                        } catch (IOException e) {
                            return 0;
                        }
                    })
                    .map(path -> path.toAbsolutePath().toString())
                    .orElse("⚠ Лог-файл не найден");
        } catch (IOException e) {
            LOGGER.error("Ошибка при поиске последнего лог-файла: {}", e.getMessage(), e);
            return "⚠ Ошибка поиска лог-файла";
        }
    }

    public static String readLastLogLines(String filePath, int lines) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            int start = Math.max(allLines.size() - lines, 0);
            return String.join("\n", allLines.subList(start, allLines.size()));
        } catch (MalformedInputException e) {
            LOGGER.warn("Ошибка чтения как UTF-8. Пробую windows-1251: {}", filePath);
            try {
                List<String> allLines = Files.readAllLines(Paths.get(filePath), Charset.forName("windows-1251"));
                int start = Math.max(allLines.size() - lines, 0);
                return String.join("\n", allLines.subList(start, allLines.size()));
            } catch (IOException ex) {
                LOGGER.error("Ошибка чтения лог-файла (windows-1251): {}", filePath, ex);
                return "⚠ Ошибка чтения логов (windows-1251)";
            }
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения лог-файла: {}", filePath, e);
            return "⚠ Ошибка чтения логов";
        }
    }
}
