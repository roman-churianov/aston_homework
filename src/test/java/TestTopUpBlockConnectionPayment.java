import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.roma.TopUpBlock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//        block.waitForElementVisibleByCssSelector("div.cards-brands.ng-tns-c2312288139-1");
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

//    <div _ngcontent-ng-c891095944="" class="cards-brands cards-brands__container ng-tns-c891095944-0 ng-trigger ng-trigger-brandsState ng-star-inserted"><img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/visa-system.svg" style=""><img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/mastercard-system.svg" style=""><img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/belkart-system.svg" style=""><!----><div _ngcontent-ng-c891095944="" class="cards-brands cards-brands_random ng-tns-c891095944-0 ng-star-inserted" style=""><img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-trigger ng-trigger-randomCardState ng-star-inserted" src="assets/images/payment-icons/card-types/maestro-system.svg" style="opacity: 1; transform: scale(1); z-index: 20;"><img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-trigger ng-trigger-randomCardState ng-star-inserted" src="assets/images/payment-icons/card-types/mir-system.svg" style="opacity: 0; transform: scale(0.9);"><!----></div><!----></div>

    @Test
    public void testIconsDisplayed() {
        WebElement divIcons = block.getDriver().findElement(By.cssSelector("div.cards-brands.cards-brands__container.ng-tns-c891095944-0.ng-trigger.ng-trigger-brandsState.ng-star-inserted"));
        List<WebElement> images = divIcons.findElements(By.tagName("img"));

        Set<String> imageSrc = new HashSet<>();
        imageSrc.add("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg");
        imageSrc.add("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg");
        imageSrc.add("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg");
        imageSrc.add("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg");
        imageSrc.add("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system.svg");

        for (WebElement img : images) {
            assertTrue(imageSrc.contains(img.getAttribute("src")));
        }
    }
/*
//    @Test
//    public void testVisaIconDisplayed() {
////        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/visa-system.svg" style="">
////        System.out.println(img.getAttribute("src"));
////            assertTrue(imageSrc.contains(img.getAttribute("src")));
//        WebElement visaImg = block.getDriver().findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
//        assertTrue(visaImg.isDisplayed());
//    }
//
//    @Test
//    public void testMasterCardIconDisplayed() {
////        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/mastercard-system.svg" style="">
//        WebElement masterCardImg = block.getDriver().findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
//        assertTrue(masterCardImg.isDisplayed());
//    }
//
//    @Test
//    public void testBelkartIconDisplayed() {
////        <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/belkart-system.svg" style="">
//        WebElement belkartImg = block.getDriver().findElement(By.cssSelector("img.ng-tns-c891095944-0.ng-star-inserted"));
//        assertTrue(belkartImg.isDisplayed());
//    }
//            assertTrue(img.isDisplayed());
//        Set<String> imageSrc = new HashSet<String>();
//        imageSrc.add("assets/images/payment-icons/card-types/visa-system.svg");
//        imageSrc.add("assets/images/payment-icons/card-types/mastercard-system.svg");
//        imageSrc.add("assets/images/payment-icons/card-types/belkart-system.svg");
*/
}
