
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

import org.roma.Arithmetics;


public class TestArithmetics {

    @Test
    public void testSum() {
        assertEquals(5, Arithmetics.sum(3, 2));
    }

    @Test
    public void testDifference() {
        assertEquals(0, Arithmetics.diff(10, 10));
    }

    @Test
    public void testMultiplication() {
        assertEquals(24, Arithmetics.multiply(4, 6));
    }

    @Test
    public void testDivision() {
        assertEquals(3.0, Arithmetics.divide(12, 4));
    }
}
