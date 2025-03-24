import com.gmail.vitali.malatok.model.TriangleArea;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    private static final Logger LOGGER = LogManager.getLogger(TriangleAreaTest.class);

    @Test
    void testValidTriangle() {
        LOGGER.info("Starting test: testValidTriangle");
        double result = TriangleArea.calculate(3, 4, 5);
        LOGGER.info("Expected: 6.0, Actual: {}", result);
        assertEquals(6.0, result, 0.001);
        LOGGER.info("testValidTriangle passed");
    }

    @Test
    void testZeroSide() {
        LOGGER.info("Starting test: testZeroSide");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(0, 4, 5));
        LOGGER.error("Caught expected exception: {}", exception.getMessage());
        LOGGER.info("testZeroSide passed");
    }

    @Test
    void testNegativeSide() {
        LOGGER.info("Starting test: testNegativeSide");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(-3, 4, 5));
        LOGGER.error("Caught expected exception: {}", exception.getMessage());
        LOGGER.info("testNegativeSide passed");
    }
}
