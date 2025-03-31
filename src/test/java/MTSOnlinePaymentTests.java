import com.gmail.vitali.malatok.model.MTSHomePage;
import com.gmail.vitali.malatok.service.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class MTSOnlinePaymentTests extends BaseTest {
    private MTSHomePage homePage;
    private static final Logger logger = Logger.getLogger(MTSOnlinePaymentTests.class.getName());

    @BeforeMethod
    public void initializePageObjects() {
        homePage = new MTSHomePage(driver);
    }

    @Test(priority = 1)
    public void testBlockTitle() {
        homePage.acceptCookies();
        Assert.assertTrue(homePage.isOnlinePaymentTitleDisplayed(), "Title 'Онлайн пополнение' is missing!");
    }

    @Test(priority = 2)
    public void testPaymentLogosPresence() {
        Assert.assertTrue(homePage.isPaymentLogoDisplayed(), "Payment logos are missing!");
    }

    @Test(priority = 3)
    public void testContinueButton() {
        String phone = ConfigReader.get("phone.number");
        String sum = ConfigReader.get("payment.amount");

        homePage.fillPaymentForm(phone, sum);
        Assert.assertTrue(homePage.closePaymentFrame(), "Failed to close payment frame!");
    }

    @Test(priority = 4)
    public void testMoreInfoLink() {
        homePage.clickMoreInfo();
        Assert.assertEquals(
                ConfigReader.get("more.info.url"),
                homePage.getCurrentUrl(),
                "Wrong redirect after clicking More Info!"
        );
    }
}
