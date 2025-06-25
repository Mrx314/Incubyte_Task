package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By HomePageHeader = By.xpath("//a[@class = \"logo\"]");
    private By SignUpButton = By.xpath("(//a[starts-with(text() ,\"Create\")])[1]");
    private By SignInButton = By.xpath("(//a[contains(text(),\"Sign In\")])[1]");

    public HomePage (WebDriver driver) {
        // Constructor for HomePage
        super(driver);
    }
    public String getHomePageHeader() {
        // Method to get the header text of the home page
        return driver.findElement(HomePageHeader).getText();
    }
    public void signIn (){
        driver.findElement(SignInButton).click();
    }
    public void signUpButton (){
        driver.findElement(SignUpButton).click();
    }

}