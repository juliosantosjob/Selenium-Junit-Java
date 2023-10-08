package saucedemo.automation.e2e.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import saucedemo.automation.e2e.support.Hooks;

public class Assertions extends Hooks {
    private static Boolean waitElement;
    private static WebDriverWait wait;

    /*
     * Comando para fazer asserções com elementos e texts
     * Ex: assertion(elemento, "meu texto");
     */

    public static void assertion(WebElement webElement, String text) {
        assertEquals(webElement.getText(), text);
    }

    /*
     * Comando para fazer asserções para elementos que contenham algum texto
     * Ex: contains(elemento, "meu texto");
     */

    public static void contains(WebElement webElement, String text) {
        assertTrue(webElement.getText().contains(text));
    }

    /*
     * Comando para fazer uma asserção de que o elemento web está visível na tela.
     * Ex: isVisible(elemento);
     */

    public static void isVisible(WebElement webElement) {
        webElement.isDisplayed();
    }

    /*
     * Comando para esperar texto ficar invisível.
     * Ex: textNotDisplayed("Texto");
     */

    public static Boolean textNotDisplayed(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='" + text + "']")));

        if (waitElement) {
            System.out.println("Text \"" + text + "\" not displayed");
        } else {
            System.out.print("Text \"" + text + "\" is displayed");
        }
        return waitElement;
    }
}