package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SignUpPage extends BasePage {
    private final By SignUpButton = By.xpath("(//a[starts-with(text() ,\"Create\")])[1]");
    private final By header = By.xpath("//h1/span");
    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By email = By.id("email_address");
    private final By password = By.id("password");
    private final By passwordConfirmation = By.id("password-confirmation");
    private final By submitButton = By.xpath("//button[@title= \"Create an Account\"]");
    private final By successMessage = By.xpath("//div[@class='message-success success message']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public String getHeader() {
        handleAdPopup();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    }

    public void register(String FM, String LN, String email, String password) {
        typeText(driver.findElement(firstName), FM);
        typeText(driver.findElement(lastName), LN);
        typeText(driver.findElement(this.email), email);
        typeText(driver.findElement(this.password), password);
        typeText(driver.findElement(passwordConfirmation), password);
        clickElement(driver.findElement(submitButton));
    }

    public void Signup() {
        WebElement signUpButton = driver.findElement(SignUpButton);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        if (signUpButton.isDisplayed()) {
            signUpButton.click();
        } else {
            throw new RuntimeException("Sign Up button is not displayed on the page.");
        }
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }
}