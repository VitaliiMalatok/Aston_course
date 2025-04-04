import service.TelegramBot;

public class TelegramTest {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        bot.sendMessageToTelegram("Test message from Java");
        // если всё настроено верно, данный скрипт отправит сообщение телеграм боту
    }
}
