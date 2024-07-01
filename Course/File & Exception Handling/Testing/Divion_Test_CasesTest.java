package Week7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class W7Q1Test {
   @Test
    public void testDivide() {
        int a = 67;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> {W7Q1.unsafeDivide(a, b);});
    }
    
    @Test
    public void testDivideSafe() {
        int a = 10;
        int b = 2;
        double expected = 5.0;
        assertEquals(expected, W7Q1.safeDivide(a, b));
    }

    @Test
    public void testDivideSafeByZero() {
        int a = 10;
        int b = 0;
        double result = W7Q1.safeDivide(a, b);
        assertEquals(Double.NaN, result);
    }
    
    @Test
    public void testDivideSafeZeroByZero() {
        int a = 0;
        int b = 0;
        assertEquals(Double.NaN, W7Q1.safeDivide(a, b));
    }
}
