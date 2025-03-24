import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestSuite {

    @BeforeClass
    public void setUp() {
        System.out.println("Starting all tests...");
    }

    @Test
    public void runTriangleTests() {
        TriangleAreaTest triangleTests = new TriangleAreaTest();
        triangleTests.testValidTriangle();
        triangleTests.testZeroSide();
        triangleTests.testNegativeSide();
    }

    @Test
    public void runCalculatorTests() {
        CalculatorTest calculatorTests = new CalculatorTest();
        calculatorTests.testAddition();
        calculatorTests.testSubtraction();
        calculatorTests.testMultiplication();
        calculatorTests.testDivision();
    }

    @Test
    public void runNumberComparatorTests() {
        NumberComparatorTest comparatorTests = new NumberComparatorTest();
        comparatorTests.testEqualNumbers();
        comparatorTests.testFirstNumberGreater();
        comparatorTests.testSecondNumberGreater();
    }

    @Test
    public void runFactorialTest() {
        FactorialTest factorialTest = new FactorialTest();
        factorialTest.testFactorialOfNegativeNumber();
        factorialTest.testFactorialOfZero();
        factorialTest.testFactorialOfZero();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("All tests finished!");
    }
}