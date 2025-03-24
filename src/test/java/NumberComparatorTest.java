import com.gmail.vitali.malatok.model.NumberComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {
    private static final Logger LOGGER = LogManager.getLogger(NumberComparatorTest.class);

    @Test
    void testFirstNumberLessThanSecond() {
        LOGGER.info("Starting test: testFirstNumberLessThanSecond");
        int result = NumberComparator.compare(3, 5);
        LOGGER.info("Expected: -1, Actual: {}", result);
        assertEquals(-1, result);
        LOGGER.info("testFirstNumberLessThanSecond passed");
    }

    @Test
    void testFirstNumberGreaterThanSecond() {
        LOGGER.info("Starting test: testFirstNumberGreaterThanSecond");
        int result = NumberComparator.compare(10, 5);
        LOGGER.info("Expected: 1, Actual: {}", result);
        assertEquals(1, result);
        LOGGER.info("testFirstNumberGreaterThanSecond passed");
    }

    @Test
    void testNumbersAreEqual() {
        LOGGER.info("Starting test: testNumbersAreEqual");
        int result = NumberComparator.compare(7, 7);
        LOGGER.info("Expected: 0, Actual: {}", result);
        assertEquals(0, result);
        LOGGER.info("testNumbersAreEqual passed");
    }
}
