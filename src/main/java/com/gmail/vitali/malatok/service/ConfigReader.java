package com.gmail.vitali.malatok.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_PATH = "src/test/resources/config.properties";
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file!", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
