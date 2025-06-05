

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

import org.roma.Factorial;

public class TestFactorial {

    @Test
    public void zeroFactorial() {
        assertEquals(1,  Factorial.factorial(0));
    }

    @Test
    public void oneFactorial() {
        assertEquals(1, Factorial.factorial(1));
    }

    @Test
    public void tenFactorial() {
        assertEquals(3628800, Factorial.factorial(10));
    }

    @Test
    public void fourFactorial() {
        assertEquals(24, Factorial.factorial(4));
    }
}
