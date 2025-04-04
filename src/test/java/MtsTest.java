import io.qameta.allure.*;
import model.MtsHomePage;
import model.PaymentFormPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import service.LogParser;
import service.TelegramBot;
import service.TestFailureHandler;
import service.TestReporter;

import java.util.List;

@Epic("MTS Online Payment")
@Feature("Payment Form Tests")
public class MtsTest extends BaseTest {
    public MtsHomePage homePage;
    public PaymentFormPage paymentFormPage;
    final String PHONE_NUMBER = "297777777";
    final double SUM_PAY_DOUBLE = 99.99;
    final String SUM_PAY_STRING = String.valueOf(SUM_PAY_DOUBLE);
    final String EMAIL = "wital@gmail.com";
    private TelegramBot bot;
    private static final Logger LOGGER = LogManager.getLogger(MtsTest.class);
    private long startTime;
    private long endTime;
    private TestFailureHandler failureHandler;


    @BeforeMethod
    @Step("Initializing Home Page")
    public void setUpPage() {
        LOGGER.info(">>> Инициализация домашней страницы и зависимостей");
        homePage = new MtsHomePage(driver);
        bot = new TelegramBot();
        failureHandler = new TestFailureHandler(bot);
        startTime = System.currentTimeMillis();
    }

    @org.testng.annotations.Test
    @Story("Verify Input Placeholders")
    @Severity(SeverityLevel.MINOR)
    @Description("Check that placeholders in input fields match expected values")
    void checkInputText() {
        LOGGER.info("=== Старт теста: Проверка плейсхолдеров ===");
        try {
            SoftAssert softAssert = new SoftAssert();
            LOGGER.info("Проверка поля 'phone'");
            softAssert.assertEquals(homePage.getPlaceholderText("phone"), "Номер телефона", "Ошибка на поле 'phone'");

            LOGGER.info("Проверка поля 'sum'");
            softAssert.assertEquals(homePage.getPlaceholderText("sum"), "Сумма", "Ошибка на поле 'sum'");

            LOGGER.info("Проверка поля 'email'");
            softAssert.assertEquals(homePage.getPlaceholderText("email"), "E-mail для отправки чека", "Ошибка на поле 'email'");

            LOGGER.info("Проверка поля 'internetPhone'");
            softAssert.assertEquals(homePage.getPlaceholderText("internetPhone"), "Номер абонента", "Ошибка на поле 'internetPhone'");

            LOGGER.info("Проверка поля 'internetSum'");
            softAssert.assertEquals(homePage.getPlaceholderText("internetSum"), "Сумма", "Ошибка на поле 'internetSum'");

            LOGGER.info("Проверка поля 'internetEmail'");
            softAssert.assertEquals(homePage.getPlaceholderText("internetEmail"), "E-mail для отправки чека", "Ошибка на поле 'internetEmail'");

            LOGGER.info("Проверка поля 'scoreInstalment'");
            softAssert.assertEquals(homePage.getPlaceholderText("scoreInstalment"), "Номер счета на 44", "Ошибка на поле 'scoreInstalment'");

            LOGGER.info("Проверка поля 'instalmentSum'");
            softAssert.assertEquals(homePage.getPlaceholderText("instalmentSum"), "Сумма", "Ошибка на поле 'instalmentSum'");

            LOGGER.info("Проверка поля 'instalmentEmail'");
            softAssert.assertEquals(homePage.getPlaceholderText("instalmentEmail"), "E-mail для отправки чека", "Ошибка на поле 'instalmentEmail'");

            LOGGER.info("Проверка поля 'arrears'");
            softAssert.assertEquals(homePage.getPlaceholderText("arrears"), "Номер счета на 2073", "Ошибка на поле 'arrears'");

            LOGGER.info("Проверка поля 'arrearsSum'");
            softAssert.assertEquals(homePage.getPlaceholderText("arrearsSum"), "Сумма", "Ошибка на поле 'arrearsSum'");

            LOGGER.info("Проверка поля 'arrearsEmail'");
            softAssert.assertEquals(homePage.getPlaceholderText("arrearsEmail"), "E-mail для отправки чека", "Ошибка на поле 'arrearsEmail'");

            softAssert.assertAll();
            LOGGER.info("Все плейсхолдеры успешно прошли проверку");
            // Проверка всех ошибок
            softAssert.assertAll();
            endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            String logs = LogParser.readLastLogLines(LogParser.getLatestLogFile("logs/"), 20);
            String message = TestReporter.generateSuccessMessage(startTime, endTime, duration, logs);
            bot.sendMessageToTelegram(message);
        } catch (AssertionError e) {
            LOGGER.error("❌ Тест упал при проверке плейсхолдеров", e);
            failureHandler.handleTestFailure("Тест зафейлился!", e);
            throw e;
        } catch (Exception e) {
            LOGGER.error("❌ Ошибка при выполнении теста checkInputText", e);
            failureHandler.handleTestFailure("Тест упал из-за ошибки: " + e.getMessage(), e);
            throw e;
        }
    }

    @org.testng.annotations.Test
    @Story("Verify Payment Form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fill in payment form and verify displayed values")
    void checkPayForm() {
        LOGGER.info("=== Старт теста: Проверка формы оплаты ===");
        try {
            LOGGER.info("Принятие cookies");
            Allure.step("Accepting cookies");
            homePage.acceptCookies();

            LOGGER.info("Инициализация страницы формы оплаты");
            Allure.step("Initializing Payment Form Page");
            paymentFormPage = new PaymentFormPage(driver);

            LOGGER.info("Заполнение формы оплаты");
            Allure.step("Filling in payment form");
            paymentFormPage.inputDataInForm(PHONE_NUMBER, SUM_PAY_STRING, EMAIL);

            LOGGER.info("Переключение во фрейм оплаты");
            Allure.step("Switching to payment iframe");
            paymentFormPage.switchToFrame();

            LOGGER.info("Получение данных из UI");
            Allure.step("Fetching payment details from UI");
            Double actualAmountOnP = paymentFormPage.getDoubleFromWebElement(
                    paymentFormPage.amountOnP, " ", 0);
            Double actualSumOnButton = paymentFormPage.getDoubleFromWebElement(
                    paymentFormPage.amountOnButton, " ", 1);
            String actualPhoneNumber = paymentFormPage.getTextFromWebElement(paymentFormPage.phoneNumberLabel)
                    .replaceAll(".*Номер:", "").trim();
            String actualTextOfC_C_Number = paymentFormPage.getTextFromWebElement(paymentFormPage.ccNumberLabel);
            String actualTextOfC_C_Exp = paymentFormPage.getTextFromWebElement(paymentFormPage.ccExpLabel);
            String actualTextOfC_C_V = paymentFormPage.getTextFromWebElement(paymentFormPage.ccVLabel);
            String actualTextOnPersonName = paymentFormPage.getTextFromWebElement(paymentFormPage.ccNameLabel);
            List<WebElement> actualLogos = paymentFormPage.getLogos();

            LOGGER.info("Валидация данных");
            Allure.step("Validating payment details");
            SoftAssert softAssert = new SoftAssert();

            // Ввод значений с проверкой
            softAssert.assertEquals(actualAmountOnP, SUM_PAY_DOUBLE, "Сумма в <p> отличается");
            softAssert.assertEquals(actualSumOnButton, SUM_PAY_DOUBLE, "Сумма на <button> отличается");
            softAssert.assertEquals(actualPhoneNumber, "375297777777", "Номер отличается");
            softAssert.assertEquals(actualTextOfC_C_Number, "Номер карты", "Отличие Номер карты");
            softAssert.assertEquals(actualTextOfC_C_Exp, "Срок действия", "Отличие Срок действия");
            softAssert.assertEquals(actualTextOfC_C_V, "CVC", "Отличие CVC");
            softAssert.assertEquals(actualTextOnPersonName, "Имя держателя (как на карте)", "Отличие Имя держателя");

            softAssert.assertAll();
            LOGGER.info("Данные формы оплаты успешно проверены");
            endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            String logs = LogParser.readLastLogLines(LogParser.getLatestLogFile("logs/"), 20);
            String message = TestReporter.generateSuccessMessage(startTime, endTime, duration, logs);
            bot.sendMessageToTelegram(message);
        } catch (AssertionError e) {
            LOGGER.error("❌ Тест упал при валидации формы оплаты", e);
            failureHandler.handleTestFailure("Тест зафейлился!", e);
            throw e;
        } catch (Exception e) {
            LOGGER.error("❌ Ошибка при выполнении теста checkPayForm", e);
            failureHandler.handleTestFailure("Тест упал из-за ошибки: " + e.getMessage(), e);
            throw e;
        }
    }
}
