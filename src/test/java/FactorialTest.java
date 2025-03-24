import com.gmail.vitali.malatok.model.Factorial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Test;

import static com.gmail.vitali.malatok.model.Factorial.logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(FactorialTest.class);

    @Test
    void testFactorialOfZero() {
        logger.info("Starting testFactorial");
        assertEquals(1, Factorial.calculate(0));
        assertEquals(120, Factorial.calculate(5));
        logger.info("testFactorial passed");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        logger.info("Starting testFactorialNegative");
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
        logger.info("testFactorialNegative passed");
    }
}
