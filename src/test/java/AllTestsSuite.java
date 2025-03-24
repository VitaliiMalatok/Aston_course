import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TriangleAreaTest.class,
        CalculatorTest.class,
        NumberComparatorTest.class,
        FactorialTest.class
})

public class AllTestsSuite {
    private static final Logger LOGGER = LogManager.getLogger(AllTestsSuite.class);

    static {
        LOGGER.info("Starting all tests...");
    }
}
