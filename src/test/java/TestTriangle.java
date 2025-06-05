
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.roma.Triangle;

public class TestTriangle {

    @Test
    @DisplayName("Triangle with sides 3, 4, 5")
    public void threeFourFiveTriangle() {
        assertEquals(6.0, Triangle.triangleArea(3, 4, 5));
    }
}
