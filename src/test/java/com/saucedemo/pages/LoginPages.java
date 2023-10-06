package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {

	@FindBy(css = "div[class='login_logo']")
	protected WebElement imgHomeSite;

	@FindBy(css = "input[id='user-name'")
	protected WebElement iptUsrName;

	@FindBy(css = "input[id='password']")
	protected WebElement iptPassword;

	@FindBy(css = "input[id='login-button']")
	protected WebElement btnSubmit;

	@FindBy(css = "span[class='title']")
	protected WebElement loggedTitle;

	@FindBy(tagName = "h3")
	protected WebElement msgError;
}