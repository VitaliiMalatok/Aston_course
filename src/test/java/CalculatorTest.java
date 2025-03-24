import com.gmail.vitali.malatok.model.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private static final Logger LOGGER = LogManager.getLogger(CalculatorTest.class);

    @Test
    public void testAddition() {
        LOGGER.info("Testing addition");
        Assert.assertEquals(Calculator.add(2, 3), 5);
    }

    @Test
    public void testSubtraction() {
        LOGGER.info("Testing subtraction");
        Assert.assertEquals(Calculator.subtract(5, 3), 2);
    }

    @Test
    public void testMultiplication() {
        LOGGER.info("Testing multiplication");
        Assert.assertEquals(Calculator.multiply(2, 3), 6);
    }

    @Test
    public void testDivision() {
        LOGGER.info("Testing division");
        Assert.assertEquals(Calculator.divide(6, 2), 3);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        LOGGER.warn("Testing division by zero, expecting ArithmeticException");
        Calculator.divide(5, 0);
    }
}