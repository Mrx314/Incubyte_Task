package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By HomePageHeader = By.xpath("//a[@class = \"logo\"]");
    private By SignUpButton = By.xpath("(//a[starts-with(text() ,\"Create\")])[1]");
    private By SignInButton = By.xpath("(//a[contains(text(),\"Sign In\")])[1]");
    private By MyAccount = By.xpath("(//button[@class=\"action switch\"])[1]") ;
    private By LogoutButton = By.partialLinkText("Sign Out");
// This class represents the Home Page of the application and extends BasePage for common functionalities
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
    public void signOut (){
        driver.findElement(MyAccount).click();
        wait.until(ExpectedConditions.elementToBeClickable(LogoutButton)).click();
    }
    public void signUpButton (){
        driver.findElement(SignUpButton).click();
    }

}