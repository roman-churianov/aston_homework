import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestOnlinePay {
    private WebDriver driver;

    public TestOnlinePay() {
    }

    @BeforeEach
    public void webPageSetup() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");

        driver.manage().window().maximize();

        WebElement cookie_button = driver.findElement(By.id("cookie-agree"));
//        System.out.println(cookie_button.getText());
        if (cookie_button.isDisplayed()) {
            cookie_button.click();
        }

    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testAccountRefillFormName() {
        WebElement section_pay = driver.findElement(By.className("pay"));
        WebElement div_wrapper = section_pay.findElement(By.className("pay__wrapper"));
        WebElement h2_pay = div_wrapper.findElement(By.tagName("h2"));
        String innerHTML = h2_pay.getAttribute("innerHTML");
//        System.out.println(innerHTML);
        assertEquals("Онлайн пополнение <br>без комиссии", innerHTML);
    }

    @Test
    public void testIconsPresence() {
        WebElement section1 = driver.findElement(By.className("pay"));
        WebElement div_pay_wrapper = section1.findElement(By.className("pay__wrapper"));
        WebElement div_pay_partners = div_pay_wrapper.findElement(By.className("pay__partners"));
        WebElement list = div_pay_partners.findElement(By.tagName("ul"));
        ArrayList<WebElement> li_images = new ArrayList<>(list.findElements(By.tagName("li")));

        Set<String> image_names = new HashSet<>();
        image_names.add("Visa");
        image_names.add("Verified By Visa");
        image_names.add("MasterCard");
        image_names.add("MasterCard Secure Code");
        image_names.add("Белкарт");

        assertEquals(image_names.size(), li_images.size());

        for (WebElement li_img : li_images) {
            WebElement image = li_img.findElement(By.tagName("img"));
//            System.out.println(image.getAttribute("alt"));
            assertTrue(image_names.contains(image.getAttribute("alt")));
        }
    }

    @Test
    public void testMoreAboutTheService() throws InterruptedException {
        WebElement div_pay_wrapper = driver.findElement(By.className("pay__wrapper"));
        WebElement link = div_pay_wrapper.findElement(By.tagName("a"));
//        System.out.println(link.getText());
        link.click();

        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void testFillFormContinue() throws InterruptedException {
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
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("app-wrapper")));

        assertTrue(driver.findElement(By.className("app-wrapper")).isDisplayed());
    }
}
