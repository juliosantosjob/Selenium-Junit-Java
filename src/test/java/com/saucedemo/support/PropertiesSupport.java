package com.saucedemo.support;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesSupport {
  private static String pathProp = "/src/test/resources/host.properties";

  public static String propLoad(String mass) {
    Properties prop = new Properties();
    try {
      InputStream input = new FileInputStream(System.getProperty("user.dir") + pathProp);
      prop.load(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return prop.getProperty(mass);
  }
}