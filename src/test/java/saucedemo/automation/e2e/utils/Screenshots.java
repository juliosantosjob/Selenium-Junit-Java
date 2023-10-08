package saucedemo.automation.e2e.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;
import saucedemo.automation.e2e.support.Hooks;

import static java.lang.Thread.sleep;

public class Screenshots extends Hooks {

  /*
   * Metodo para tirar screenshots para evidenciar os testes.
   */

  public static void makingScreenshots() {
    try {
      sleep(2000);
      File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
    } catch (Exception e) {
      System.out.println("Error implementing screenshot!");
    }
  }
}