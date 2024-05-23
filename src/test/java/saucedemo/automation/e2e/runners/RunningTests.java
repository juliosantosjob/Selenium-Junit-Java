package saucedemo.automation.e2e.runners;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import saucedemo.automation.e2e.tests.PurchasesTest;
import saucedemo.automation.e2e.tests.LoginTest;

@Suite
@SelectClasses({ PurchasesTest.class, LoginTest.class })
@SelectPackages("src/test/java/saucedemo.automation.e2e")
@IncludeTags("regression")
public class RunningTests {}