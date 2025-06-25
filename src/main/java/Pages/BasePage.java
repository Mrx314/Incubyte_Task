package Pages;

import DriverUtil.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = DriverUtil.getdriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10)); // Default wait time of 10 seconds

    }
    public String navigateTo(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        driver.get(url);
        return driver.getCurrentUrl();

    }
}
