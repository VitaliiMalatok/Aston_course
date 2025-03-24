import com.gmail.vitali.malatok.model.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static final Logger LOGGER = LogManager.getLogger(CalculatorTest.class);

    @Test
    void testAddition() {
        LOGGER.info("Starting test: testAddition");
        int result = Calculator.add(5, 3);
        LOGGER.info("Expected: 8, Actual: {}", result);
        assertEquals(8, result);
        LOGGER.info("testAddition passed");
    }

    @Test
    void testSubtraction() {
        LOGGER.info("Starting test: testSubtraction");
        int result = Calculator.subtract(10, 4);
        LOGGER.info("Expected: 6, Actual: {}", result);
        assertEquals(6, result);
        LOGGER.info("testSubtraction passed");
    }

    @Test
    void testMultiplication() {
        LOGGER.info("Starting test: testMultiplication");
        int result = Calculator.multiply(3, 7);
        LOGGER.info("Expected: 21, Actual: {}", result);
        assertEquals(21, result);
        LOGGER.info("testMultiplication passed");
    }

    @Test
    void testDivision() {
        LOGGER.info("Starting test: testDivision");
        double result = Calculator.divide(10, 2);
        LOGGER.info("Expected: 5.0, Actual: {}", result);
        assertEquals(5.0, result, 0.001);
        LOGGER.info("testDivision passed");
    }

    @Test
    void testDivisionByZero() {
        LOGGER.info("Starting test: testDivisionByZero");
        Exception exception = assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
        LOGGER.error("Caught expected exception: {}", exception.getMessage());
        LOGGER.info("testDivisionByZero passed");
    }
}
