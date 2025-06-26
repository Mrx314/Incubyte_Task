import DriverUtil.DriverUtil;
import Pages.HomePage;
import Pages.SignUpPage;
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
            signUpPage.register("John", "klaus", "johpna12@example.com", "Password123");
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