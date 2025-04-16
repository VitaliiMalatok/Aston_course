import io.qameta.allure.*;
import model.MtsHomePage;
import model.PaymentFormPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import service.*;

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

            checkPlaceholder(softAssert, "phone", "Номер телефона");
            checkPlaceholder(softAssert, "sum", "Сумма");
            checkPlaceholder(softAssert, "email", "E-mail для отправки чека");
            checkPlaceholder(softAssert, "internetPhone", "Номер абонента");
            checkPlaceholder(softAssert, "internetSum", "Сумма");
            checkPlaceholder(softAssert, "internetEmail", "E-mail для отправки чека");
            checkPlaceholder(softAssert, "scoreInstalment", "Номер счета на 44");
            checkPlaceholder(softAssert, "instalmentSum", "Сумма");
            checkPlaceholder(softAssert, "instalmentEmail", "E-mail для отправки чека");
            checkPlaceholder(softAssert, "arrears", "Номер счета на 2073");
            checkPlaceholder(softAssert, "arrearsSum", "Сумма");
            checkPlaceholder(softAssert, "arrearsEmail", "E-mail для отправки чека");

            softAssert.assertAll();
            LOGGER.info("Все плейсхолдеры успешно прошли проверку");

            reportSuccessToTelegram();
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

    private void checkPlaceholder(SoftAssert softAssert, String fieldId, String expectedText) {
        LOGGER.info("Проверка поля '" + fieldId + "'");
        Allure.step("Проверка плейсхолдера: " + fieldId);
        softAssert.assertEquals(homePage.getPlaceholderText(fieldId), expectedText,
                "Ошибка на поле '" + fieldId + "'");
    }

    @org.testng.annotations.Test
    @Story("Verify Payment Form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fill in payment form and verify displayed values")
    void checkPayForm() {
        LOGGER.info("=== Старт теста: Проверка формы оплаты ===");
        try {
            LOGGER.info("Принятие cookies");
            Allure.step("Принятие cookies");
            homePage.acceptCookies();

            LOGGER.info("Инициализация страницы формы оплаты");
            Allure.step("Инициализация страницы формы оплаты");
            paymentFormPage = new PaymentFormPage(driver);

            LOGGER.info("Заполнение формы оплаты и переход во фрейм");
            Allure.step("Заполнение формы оплаты и переход во фрейм");
            PaymentFormUtils.fillPaymentForm(paymentFormPage, PHONE_NUMBER, SUM_PAY_STRING, EMAIL);

            LOGGER.info("Проверка данных, отображённых в форме");
            Allure.step("Проверка данных, отображённых в форме");
            SoftAssert softAssert = new SoftAssert();
            PaymentFormUtils.validatePaymentDetails(paymentFormPage, SUM_PAY_DOUBLE, "375" + PHONE_NUMBER, softAssert);

            softAssert.assertAll();
            LOGGER.info("Форма оплаты успешно прошла валидацию");

            reportSuccessToTelegram();
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

    private void reportSuccessToTelegram() {
        endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String logs = LogParser.readLastLogLines(LogParser.getLatestLogFile("logs/"), 20);
        String message = TestReporter.generateSuccessMessage(startTime, endTime, duration, logs);
        bot.sendMessageToTelegram(message);
    }
}
