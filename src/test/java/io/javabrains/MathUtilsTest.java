package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
public class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running the " + testInfo.getDisplayName() + " method with tags " + testInfo.getTags());
    }

    @Nested
    @DisplayName("add method")
    @Tag("ArithmeticTest")
    class AddTest {

        @Test
        @DisplayName("when adding two positive numbers")
        void testAddForPositiveNumbers() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, () -> "should return the right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddForNegativeNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, () -> "should return the right sum");
        }

    }

    @Test
    @Tag("ArithmeticTest")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), () -> "divide method should throw" +
                " an Arithmetic Exception when denominator is 0.");
    }

    @Test
    @Tag("ArithmeticTest")
    @DisplayName("Test Multiply")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @Tag("GeometricTest")
    void testComputeCircleArea() {
        double expected = 314.1592653589793;
        double actual =  mathUtils.computeCircleArea(10);
        assertEquals(expected, actual);
    }

}
