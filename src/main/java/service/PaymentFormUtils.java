package service;

import model.PaymentFormPage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PaymentFormUtils {

    public static void fillPaymentForm(PaymentFormPage paymentFormPage, String phone, String sum, String email) {
        paymentFormPage.inputDataInForm(phone, sum, email);
        paymentFormPage.switchToFrame();
    }

    public static void validatePaymentDetails(PaymentFormPage paymentFormPage, double expectedSum, String expectedPhone, SoftAssert softAssert) {
        Double actualAmountOnP = paymentFormPage.getDoubleFromWebElement(paymentFormPage.amountOnP, " ", 0);
        Double actualSumOnButton = paymentFormPage.getDoubleFromWebElement(paymentFormPage.amountOnButton, " ", 1);
        String actualPhoneNumber = paymentFormPage.getTextFromWebElement(paymentFormPage.phoneNumberLabel)
                .replaceAll(".*Номер:", "").trim();
        String actualTextOfC_C_Number = paymentFormPage.getTextFromWebElement(paymentFormPage.ccNumberLabel);
        String actualTextOfC_C_Exp = paymentFormPage.getTextFromWebElement(paymentFormPage.ccExpLabel);
        String actualTextOfC_C_V = paymentFormPage.getTextFromWebElement(paymentFormPage.ccVLabel);
        String actualTextOnPersonName = paymentFormPage.getTextFromWebElement(paymentFormPage.ccNameLabel);
        List<WebElement> actualLogos = paymentFormPage.getLogos();
        softAssert.assertEquals(actualAmountOnP, expectedSum, "Сумма в <p> отличается");
        softAssert.assertEquals(actualSumOnButton, expectedSum, "Сумма на <button> отличается");
        softAssert.assertEquals(actualPhoneNumber, expectedPhone, "Номер отличается");
        softAssert.assertEquals(actualTextOfC_C_Number, "Номер карты", "Отличие Номер карты");
        softAssert.assertEquals(actualTextOfC_C_Exp, "Срок действия", "Отличие Срок действия");
        softAssert.assertEquals(actualTextOfC_C_V, "CVC", "Отличие CVC");
        softAssert.assertEquals(actualTextOnPersonName, "Имя держателя (как на карте)", "Отличие Имя держателя");
        softAssert.assertTrue(actualLogos != null && !actualLogos.isEmpty(), "Не отображаются логотипы платёжных систем");
    }
}
