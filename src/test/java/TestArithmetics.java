
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.roma.Arithmetics;

public class TestArithmetics {

    @Test
    @DisplayName("Simple sum test")
    public void testSum() {
        assertEquals(5, Arithmetics.sum(3, 2));
    }

    @Test
    @DisplayName("Simple difference test")
    public void testDifference() {
        assertEquals(0, Arithmetics.diff(10, 10));
    }

    @Test
    @DisplayName("Simple multiplication test")
    public void testMultiplication() {
        assertEquals(24, Arithmetics.multiply(4, 6));
    }

    @Test
    @DisplayName("Simple division test")
    public void testDivision() {
        assertEquals(3.0, Arithmetics.divide(12, 4));
    }
}
