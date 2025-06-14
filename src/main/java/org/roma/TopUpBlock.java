package org.roma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopUpBlock {
    private final WebDriver driver;

    public TopUpBlock() {
        driver = new ChromeDriver();
    }

    public TopUpBlock(WebDriver driver) {
        this.driver = driver;
    }

    public String getPlaceholder(String id) {
        WebElement phone_field = driver.findElement(By.id(id));
        return phone_field.getAttribute("placeholder");
    }

    public void quitDriver() {
        driver.quit();
    }
}
