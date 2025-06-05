
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

import org.roma.Triangle;

public class TestTriangle {

    @Test
    public void threeFourFiveTriangle() {
        assertEquals(6.0, Triangle.triangleArea(3, 4, 5));
    }
}
