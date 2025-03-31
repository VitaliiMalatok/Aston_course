package com.gmail.vitali.malatok.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class MTSHomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger LOGGER = LogManager.getLogger(MTSHomePage.class);

    private final By acceptCookiesButton = By.xpath("//button[contains(text(), 'Принять')]");
    private final By titleOnlinePayment = By.xpath("//h2[contains(text(),'Онлайн пополнение ')]");
    private final By paymentLogoVisa = By.xpath("//img[@alt='Visa']");
    private final By inputPhone = By.id("connection-phone");
    private final By inputSum = By.id("connection-sum");
    private final By continueButton = By.xpath("//button[@class='button button__default ']");
    private final By paymentFrame = By.className("bepaid-iframe");
    private final By closeButton = By.xpath("//svg-icon[@class='header__close-icon']");
    private final By moreInfoLink = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    private final By chatButton = By.className("webim-button-corner");

    public MTSHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookies() {
        try {
            WebElement button = driver.findElement(acceptCookiesButton);
            button.click();
            LOGGER.info("Accepted cookies.");
        } catch (Exception e) {
            LOGGER.warn("Cookie acceptance button not found.");
        }
    }

    public boolean isOnlinePaymentTitleDisplayed() {
        boolean isDisplayed = driver.findElement(titleOnlinePayment).isDisplayed();
        LOGGER.info("Title 'Онлайн пополнение' displayed: " + isDisplayed);
        return isDisplayed;
    }

    public boolean isPaymentLogoDisplayed() {
        boolean isDisplayed = driver.findElement(paymentLogoVisa).isDisplayed();
        LOGGER.info("Visa payment logo displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void fillPaymentForm(String phone, String sum) {
        LOGGER.info("Filling payment form with phone: " + phone + " and sum: " + sum);
        driver.findElement(inputPhone).sendKeys(phone);
        driver.findElement(inputSum).sendKeys(sum);
        driver.findElement(continueButton).click();
    }

    public boolean closePaymentFrame() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();
        driver.switchTo().defaultContent();
        LOGGER.info("Payment frame closed.");
        return true;
    }

    public void closeChatButton() {
        try {
            WebElement chat = driver.findElement(chatButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", chat);
            LOGGER.info("Chat button hidden.");
        } catch (Exception e) {
            LOGGER.warn("Chat button not found.");
        }
    }

    public void clickMoreInfo() {
        closeChatButton();
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        link.click();
        LOGGER.info("Clicked 'More Info' link.");
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        LOGGER.info("Current URL: " + url);
        return url;
    }
}
