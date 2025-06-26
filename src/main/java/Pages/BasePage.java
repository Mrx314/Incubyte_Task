package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final By closeButtonLocator = By.xpath("//*[@id=\"dismiss-button\"]/div");
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickElement(WebElement element) {
        waitForElementToBeVisible(element).click();
    }

    protected void typeText(WebElement element, String text) {
        WebElement visibleElement = waitForElementToBeVisible(element);
        visibleElement.clear();
        visibleElement.sendKeys(text);
    }

    protected void handleAlert(boolean accept) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            if (accept) {
                driver.switchTo().alert().accept();
            } else {
                driver.switchTo().alert().dismiss();
            }
        } catch (Exception e) {
            throw new RuntimeException("No alert present or unable to handle alert: " + e.getMessage());
        }
    }

    protected void handleAdPopup() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

    }
}