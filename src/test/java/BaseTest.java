import com.gmail.vitali.malatok.service.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        LOGGER.info("Setting up WebDriver...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String baseUrl = ConfigReader.get("base.url");
        driver.get(baseUrl);
        LOGGER.info("Navigated to: " + baseUrl);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            LOGGER.info("Closing WebDriver...");
            driver.quit();
        }
    }
}
