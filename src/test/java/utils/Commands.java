package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Hooks;

public class Commands extends Hooks {
  private static WebDriverWait wait;

  /*
   * Comando para clicar em elementos web.
   * Ex: click(elemento);
   */

  public static void click(WebElement webElement) {
    webElement.click();
  }

  /*
   * Comando para preenchimento de inputs.
   * Ex: fill(elemento, "meu texto");
   */

  public static void fill(WebElement webElement, String text) {
    webElement.sendKeys(text);
  }

  /*
   * Comando para clicar em botões pelo seu texto.
   * Ex: clickText("meu texto");
   */

  public static void clickText(String text) {
    try {
      driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
    } catch (Exception e) {
      System.out.println("Unable to click text!");
    }
  }

  /*
   * Comando para aguardar elementos web estarem visiveis por um tempo
   * determidado.
   * Ex: waitForElement(elemento, 10);
   */

  public static WebElement waitForElement(WebElement webElement, int timeout) {
    try {
      wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.elementToBeClickable(webElement));
      webElement.isDisplayed();
    } catch (Exception e) {
      System.out.println("Unable to wait for element!");
    }
    return webElement;
  }

  /*
   * Comando para clicar em elemento usando javascript.
   * Ex: realClick(elemento);
   */

  public static WebElement realClick(WebElement webElement) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", webElement);
    return webElement;
  }

  /*
   * Comando para scrollar até um elemento na tela.
   * Ex: scrollTo(elemento);
   */

  public static WebElement scrollTo(WebElement webElement) {
    try {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    } catch (Exception e) {
      System.out.println(e.getCause());
    }
    return webElement;
  }
}