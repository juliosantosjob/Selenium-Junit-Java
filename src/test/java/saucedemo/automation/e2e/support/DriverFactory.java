package saucedemo.automation.e2e.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.logging.Level;

import static java.lang.System.getProperty;

public class DriverFactory {
    protected static WebDriver driver;
    private static String browser = getProperty("BROWSER");

    public void initializeWebDriver() {
        if (browser == null) {
            browser = "chrome";
        }

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                WebDriverManager.chromedriver().setup();
                driver = new EdgeDriver();
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions headlessChromeOptions = new ChromeOptions();
                headlessChromeOptions.addArguments("--headless");
                headlessChromeOptions.addArguments("--remote-allow-origins=*");
                headlessChromeOptions.addArguments("--window-size=1920x1080");
                driver = new ChromeDriver(headlessChromeOptions);
                break;

            case "edge-headless":
                WebDriverManager.chromedriver().setup();
                EdgeOptions headlessEdgeOptions = new EdgeOptions();
                headlessEdgeOptions.addArguments("headless");
                headlessEdgeOptions.addArguments("--window-size=1920x1080");
                driver = new EdgeDriver(headlessEdgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Invalid browser argument!");
        }
    }

    public void closeWebDriver() {
        driver.quit();
    }
}