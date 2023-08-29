package runners;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import tests.PurchasesTest;
import tests.LoginTest;

@Suite
@SelectClasses({ PurchasesTest.class, LoginTest.class })
@SelectPackages("src/test/java/tests")
@IncludeTags("regression")
public class RunningTests {}