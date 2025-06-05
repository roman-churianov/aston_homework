
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.roma.Factorial;

public class TestFactorial {

    @Test
    @DisplayName("0 factorial")
    public void zeroFactorial() {
        assertEquals(1,  Factorial.factorial(0));
    }

    @Test
    @DisplayName("1 factorial")
    public void oneFactorial() {
        assertEquals(1, Factorial.factorial(1));
    }

    @Test
    @DisplayName("10 factorial")
    public void tenFactorial() {
        assertEquals(3628800, Factorial.factorial(10));
    }

    @Test
    @DisplayName("4 factorial")
    public void fourFactorial() {
        assertEquals(24, Factorial.factorial(4));
    }
}
