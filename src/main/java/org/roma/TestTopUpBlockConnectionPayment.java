package org.roma;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTopUpBlockConnectionPayment {

    private TopUpBlock block;
    private WebDriver driver;

    public TestTopUpBlockConnectionPayment() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://mts.by");
//        block = new TopUpBlock(driver);
        this.driver = new ChromeDriver();
        driver.get("https://mts.by");

        WebElement cookie_button = driver.findElement(By.id("cookie-agree"));
//        System.out.println(cookie_button.getText());
        if (cookie_button.isDisplayed()) {
            cookie_button.click();
        }
    }

    @Test
    public void test() {
        WebElement phone_number = driver.findElement(By.id("connection-phone"));
        phone_number.sendKeys("297777777");
        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.sendKeys("300");
        WebElement button = driver.findElement(By.cssSelector("button.button.button__default"));
//        System.out.println(button.getText());
        button.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        WebElement iframe = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(iframe);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("app-wrapper__content")));
        WebElement sum_label = driver.findElement(By.className("pay-description__cost"));
        WebElement span_label = sum_label.findElement(By.tagName("span"));
//        System.out.println(span_label.getText());
        assertTrue(span_label.getText().startsWith("300"));

        WebElement pay_button = driver.findElement(By.cssSelector("button.colored.disabled"));
        String buttonLabelText = pay_button.getText();
//        System.out.println(buttonLabelText);
        assertTrue(buttonLabelText.contains("300"));

        WebElement payNumberDiv = driver.findElement(By.className("pay-description__text"));
        String payNumberSpanText = payNumberDiv.findElement(By.tagName("span")).getText();
//        System.out.println(payNumberSpanText);
        assertTrue(payNumberSpanText.endsWith("375297777777"));

//        <label _ngcontent-ng-c2312288139="" class="ng-tns-c2312288139-1 ng-star-inserted">Номер карты</label>
        WebElement cardNumberPlaceholder = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-1.ng-star-inserted"));
//        System.out.println(cardNumberPlaceholder.getText());
        assertEquals("Номер карты", cardNumberPlaceholder.getText());

//        <label _ngcontent-ng-c2312288139="" class="ng-tns-c2312288139-4 ng-star-inserted">Срок действия</label>
        WebElement cardDatePlaceholder = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-4.ng-star-inserted"));
//        System.out.println(cardDatePlaceholder.getText());
        assertEquals("Срок действия", cardDatePlaceholder.getText());

//        <label _ngcontent-ng-c2312288139="" class="ng-tns-c2312288139-5 ng-star-inserted">CVC</label>
        WebElement cvcPlaceholder = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-5.ng-star-inserted"));
//        System.out.println(cvcPlaceholder.getText());
        assertEquals("CVC", cvcPlaceholder.getText());

//        <label _ngcontent-ng-c2312288139="" class="ng-tns-c2312288139-3 ng-star-inserted">Имя и фамилия на карте</label>
        WebElement namePlaceholder = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-3.ng-star-inserted"));
//        System.out.println(namePlaceholder.getText());
        assertEquals("Имя и фамилия на карте", namePlaceholder.getText());

//        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/visa-system.svg" style="">
        WebElement visaImg = driver.findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
        assertTrue(visaImg.isDisplayed());

//        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/mastercard-system.svg" style="">
        WebElement masterCardImg = driver.findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
        assertTrue(masterCardImg.isDisplayed());

//        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/belkart-system.svg" style="">
        WebElement belkartImg = driver.findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
        assertTrue(belkartImg.isDisplayed());
    }
}
