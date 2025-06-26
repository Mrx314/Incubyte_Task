import DriverUtil.DriverUtil;
import Pages.HomePage;
import Pages.SignUpPage;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpTest {
    private static final Logger logger = LoggerFactory.getLogger(SignUpTest.class);
    private WebDriver driver;
    private SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverUtil.getdriver(); // Use a driver utility/factory
        signUpPage = new SignUpPage(driver);
        logger.info("WebDriver initialized and SignUpPage loaded.");
    }

    @Test
    public void testSignUp() {
        try {
            signUpPage.Signup();

            String header = signUpPage.getHeader();
            Assert.assertEquals(header, "Create New Customer Account", "Header text mismatch!");

            String firstName = RandomString.make(8);
            String lastName = RandomString.make(8);
            String email = RandomString.make(5) + "@example.com";
            String password = RandomString.make(10);

            signUpPage.register(firstName, lastName, email, password);

            Assert.assertEquals("Thank you for registering with Main Website Store." ,signUpPage.getSuccessMessage());
            logger.info("Sign-up test passed.");
        } catch (Exception e) {
            logger.error("Sign-up test failed: {}", e.getMessage());
            Assert.fail("Sign-up test failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed.");
        }
    }
}