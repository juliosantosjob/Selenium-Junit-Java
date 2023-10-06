package com.saucedemo.runners;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import com.saucedemo.tests.PurchasesTest;
import com.saucedemo.tests.LoginTest;

@Suite
@SelectClasses({ PurchasesTest.class, LoginTest.class })
@SelectPackages("src/test/java/com.saucedemo.tests")
@IncludeTags("regression")
public class RunningTests {}