package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    void testDivide() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide method should throw" +
                " an Arithmetic Exception when denominator is 0.");
    }

    @Test
    void testComputeCircleArea() {
        MathUtils mathUtils = new MathUtils();
        double expected = 314.1592653589793;
        double actual =  mathUtils.computeCircleArea(10);
        assertEquals(expected, actual);
    }

}
