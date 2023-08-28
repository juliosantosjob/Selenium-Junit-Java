package runners;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import tests.AddToCartTest;
import tests.LoginTest;

@Suite
@SelectClasses({ AddToCartTest.class, LoginTest.class })
@SelectPackages("src/test/java/tests")
@IncludeTags("regression")
public class RunningTests {}