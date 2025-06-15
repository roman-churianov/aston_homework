package org.roma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopUpBlock {
    private final WebDriver driver;

    public TopUpBlock() {
        driver = new ChromeDriver();
    }

    public TopUpBlock(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieAcceptButton() {
        WebElement cookie_button = driver.findElement(By.id("cookie-agree"));
//        System.out.println(cookie_button.getText());
        if (cookie_button.isDisplayed()) {
            cookie_button.click();
        }
    }

    public void switchToIFrame(String iFrameClassName) {
        WebElement iframe = driver.findElement(By.className(iFrameClassName));
        driver.switchTo().frame(iframe);
    }

    public String getPlaceholder(String id) {
        WebElement phone_field = driver.findElement(By.id(id));
        return phone_field.getAttribute("placeholder");
    }

    public String getPlaceholderTextByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector)).getText();
    }

    public void setUpPhoneNumber(String phoneNumber) {
        WebElement phone_number = driver.findElement(By.id("connection-phone"));
        phone_number.sendKeys(phoneNumber);
    }

    public void sendCost(String cost) {
        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.sendKeys(cost);
    }

    public void buttonClick(String buttonCssSelector) {
        WebElement button = driver.findElement(By.cssSelector(buttonCssSelector));
//        System.out.println(button.getText());
        button.click();
    }

    public void waitForElementVisible(String className) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
