import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.roma.TopUpBlock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTopUpBlockConnectionPayment {

    private TopUpBlock block;

    public TestTopUpBlockConnectionPayment() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mts.by");
        block = new TopUpBlock(driver);
        block.clickCookieAcceptButton();
    }

    @BeforeEach
    public void setUp() {
        block.setUpPhoneNumber("297777777");

        block.sendCost("300");

        block.buttonClick("button.button.button__default");

        block.waitForElementVisible("bepaid-iframe");

        block.switchToIFrame("bepaid-iframe");

        block.waitForElementVisible("app-wrapper__content");
    }

    @AfterEach
    public void tearDown() {
        block.quitDriver();
    }

    @Test
    public void testLabelCostDisplay() {
        WebElement sum_label = block.getDriver().findElement(By.className("pay-description__cost"));
        WebElement span_label = sum_label.findElement(By.tagName("span"));
//        System.out.println(span_label.getText());
        assertTrue(span_label.getText().startsWith("300"));
    }

    @Test
    public void testButtonCostDisplay() {
        WebElement pay_button = block.getDriver().findElement(By.cssSelector("button.colored.disabled"));
        String buttonLabelText = pay_button.getText();
//        System.out.println(buttonLabelText);
        assertTrue(buttonLabelText.contains("300"));
    }

    @Test
    public void testPhoneNumberLabel() {
        WebElement payNumberDiv = block.getDriver().findElement(By.className("pay-description__text"));
        String payNumberSpanText = payNumberDiv.findElement(By.tagName("span")).getText();
//        System.out.println(payNumberSpanText);
        assertTrue(payNumberSpanText.endsWith("375297777777"));
    }

    @Test
    public void testCardNumberPlaceholder() {
        assertEquals("Номер карты", block.getPlaceholderTextByCssSelector("label.ng-tns-c2312288139-1.ng-star-inserted"));
    }

    @Test
    public void testCardDatePlaceholder() {
        assertEquals("Срок действия", block.getPlaceholderTextByCssSelector("label.ng-tns-c2312288139-4.ng-star-inserted"));
    }

    @Test
    public void testCardCVCPlaceholder() {
        assertEquals("CVC", block.getPlaceholderTextByCssSelector("label.ng-tns-c2312288139-5.ng-star-inserted"));
    }

    @Test
    public void testCardNamePlaceholder() {
        assertEquals("Имя и фамилия на карте", block.getPlaceholderTextByCssSelector("label.ng-tns-c2312288139-3.ng-star-inserted"));
    }

    @Test
    public void testVisaIconDisplayed() {
//        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/visa-system.svg" style="">
        WebElement visaImg = block.getDriver().findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
        assertTrue(visaImg.isDisplayed());
    }

    @Test
    public void testMasterCardIconDisplayed() {
//        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/mastercard-system.svg" style="">
        WebElement masterCardImg = block.getDriver().findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
        assertTrue(masterCardImg.isDisplayed());
    }

    @Test
    public void testBelkartIconDisplayed() {
//        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/belkart-system.svg" style="">
        WebElement belkartImg = block.getDriver().findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
        assertTrue(belkartImg.isDisplayed());
    }
}
