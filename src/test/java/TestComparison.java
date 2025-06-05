
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.roma.Comparison;

public class TestComparison {

    @Test
    @DisplayName("Test a is less than b")
    public void testLess() {
        assertTrue(Comparison.compare(-10, 2) < 0);
    }

    @Test
    @DisplayName("Test a equals b")
    public void testEqual() {
        assertEquals(0, Comparison.compare(49, 49));
    }

    @Test
    @DisplayName("Test a bigger b")
    public void testGreater() {
        assertTrue(Comparison.compare(34, 9) > 0);
    }
}
