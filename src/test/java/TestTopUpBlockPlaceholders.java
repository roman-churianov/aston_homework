import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.roma.TopUpBlock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTopUpBlockPlaceholders {
    private final TopUpBlock block;

    public TestTopUpBlockPlaceholders() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mts.by");
        block = new TopUpBlock(driver);
    }

    @AfterEach
    public void tearDown() {
        block.quitDriver();
    }

    // Телефон
    @Test
    public void testConnectionPhonePlaceholder() {
        String phone_placeholder = block.getPlaceholder("connection-phone");
        assertEquals("Номер телефона", phone_placeholder);
    }

    @Test
    public void testConnectionSumPlaceholder() {
        String sum_placeholder = block.getPlaceholder("connection-sum");
        assertEquals("Сумма", sum_placeholder);
    }

    @Test
    public void testConnectionEmailPlaceholder() {
        String email_placeholder = block.getPlaceholder("connection-email");
        assertEquals("E-mail для отправки чека", email_placeholder);
    }

    // Интернет
    @Test
    public void testInternetPhonePlaceholder() {
        assertEquals("Номер абонента", block.getPlaceholder("internet-phone"));
    }

    @Test
    public void testInternetSumPlaceholder() {
        assertEquals("Сумма", block.getPlaceholder("internet-sum"));
    }

    @Test
    public void testInternetEmailPlaceholder() {
        assertEquals("E-mail для отправки чека", block.getPlaceholder("internet-email"));
    }

    // Рассрочка
    @Test
    public void testInstallmentAccountPlaceholder() {
        assertEquals("Номер счета на 44", block.getPlaceholder("score-instalment"));
    }

    @Test
    public void testInstallmentSumPlaceholder() {
        assertEquals("Сумма", block.getPlaceholder("instalment-sum"));
    }

    @Test
    public void testInstallmentEmailPlaceholder() {
        assertEquals("E-mail для отправки чека", block.getPlaceholder("instalment-email"));
    }

     // Задолженность
    @Test
    public void testArrearsAccountPlaceholder() {
        assertEquals("Номер счета на 2073", block.getPlaceholder("score-arrears"));
    }

    @Test
    public void testArrearsSumPlaceholder() {
        assertEquals("Сумма", block.getPlaceholder("arrears-sum"));
    }

    @Test
    public void testArrearsEmailPlaceholder() {
        assertEquals("E-mail для отправки чека", block.getPlaceholder("arrears-email"));
    }
}
