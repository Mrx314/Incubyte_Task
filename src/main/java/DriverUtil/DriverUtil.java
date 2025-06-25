package DriverUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverUtil {
    static WebDriver driver;

    public static String readConfig(String propertyName) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
            prop.getProperty(propertyName);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }// This is just a placeholder, actual implementation will depend on the properties file structure
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName) ;

    }

    public static WebDriver getdriver() {
        String browser = readConfig("browser");
        String url = readConfig("baseUrl");

        if (browser == null || url == null) {
            throw new IllegalArgumentException("Browser or URL not specified in config file");
        }
        switch (browser.toLowerCase()) {
            case "chrome":
                // Initialize ChromeDriver
                driver = new ChromeDriver();
                driver.get(url);
                break;
            case "firefox":
                // Initialize FirefoxDriver
                driver = new FirefoxDriver();
                driver.get(url);
                break;
            case "edge":
                // Initialize EdgeDriver
                driver = new EdgeDriver();
                driver.get(url);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
