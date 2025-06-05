
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.roma.Comparison;

public class TestComparison {

    @Test
    public void testLess() {
        assertTrue(Comparison.compare(-10, 2) < 0);
    }

    @Test
    public void testEqual() {
        assertEquals(0, Comparison.compare(49, 49));
    }

    @Test
    public void testGreater() {
        assertTrue(Comparison.compare(34, 9) > 0);
    }
}
