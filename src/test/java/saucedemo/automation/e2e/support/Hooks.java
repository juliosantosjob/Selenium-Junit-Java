package saucedemo.automation.e2e.support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.time.Duration;

import static java.lang.System.out;
import static saucedemo.automation.e2e.utils.Screenshots.*;

public class Hooks extends DriverFactory {

    /* Hooks config runner. */

    @BeforeEach
    public void beforeTests(TestInfo test) {
        out.println("**************************************************");
        out.println("Scenario: '" + test.getDisplayName() + "' in running");
        out.println("Tag execution: " + test.getTags());
        out.println("**************************************************");

        initializeWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(PropertiesSupport.propLoad("URL_BASE"));
    }

    @AfterEach
    public void afterTests() {
        out.println(" ");
        out.println("Finishing Test Execution...");
        out.println(" ");
        makingScreenshots();
        closeWebDriver();
    }
}