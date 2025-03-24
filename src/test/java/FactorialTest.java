import com.gmail.vitali.malatok.model.Factorial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {
    private static final Logger LOGGER = LogManager.getLogger(FactorialTest.class);

    @Test
    public void testFactorialOfPositiveNumber() {
        LOGGER.info("Running test: testFactorialOfPositiveNumber");
        assertEquals(Factorial.calculate(5), 120);
    }

    @Test
    public void testFactorialOfZero() {
        LOGGER.info("Running test: testFactorialOfZero");
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        LOGGER.info("Running test: testFactorialOfNegativeNumber");
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}