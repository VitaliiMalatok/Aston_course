import com.gmail.vitali.malatok.model.TriangleArea;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTest {
    private static final Logger LOGGER = LogManager.getLogger(TriangleAreaTest.class);

    @Test
    public void testValidTriangle() {
        LOGGER.info("Testing valid triangle with sides 3, 4, 5");
        Assert.assertEquals(TriangleArea.calculate(3, 4, 5), 6.0, 0.001);
    }

    @Test
    public void testZeroSide() {
        LOGGER.info("Testing triangle with zero side");
        Assert.expectThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(0, 4, 5));
    }

    @Test
    public void testNegativeSide() {
        LOGGER.info("Testing triangle with negative side");
        Assert.expectThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(-3, 4, 5));
    }
}
