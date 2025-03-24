import com.gmail.vitali.malatok.model.NumberComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTest {
    private static final Logger LOGGER = LogManager.getLogger(NumberComparatorTest.class);

    @Test
    public void testEqualNumbers() {
        LOGGER.info("Testing equal numbers");
        Assert.assertEquals(NumberComparator.compare(5, 5), 0);
    }

    @Test
    public void testFirstNumberGreater() {
        LOGGER.info("Testing when first number is greater");
        Assert.assertEquals(NumberComparator.compare(10, 5), 1);
    }

    @Test
    public void testSecondNumberGreater() {
        LOGGER.info("Testing when second number is greater");
        Assert.assertEquals(NumberComparator.compare(5, 10), -1);
    }
}