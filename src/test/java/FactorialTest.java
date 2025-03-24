import com.gmail.vitali.malatok.model.Factorial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    private static final Logger LOGGER = LogManager.getLogger(FactorialTest.class);

    @Test
    void testFactorialOfZero() {
        LOGGER.info("Starting testFactorial");
        assertEquals(1, Factorial.calculate(0));
        assertEquals(120, Factorial.calculate(5));
        LOGGER.info("testFactorial passed");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        LOGGER.info("Starting testFactorialNegative");
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
        LOGGER.info("testFactorialNegative passed");
    }
}
