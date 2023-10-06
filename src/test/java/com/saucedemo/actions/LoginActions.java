package com.saucedemo.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static com.saucedemo.utils.Assertions.assertion;
import static com.saucedemo.utils.Assertions.isVisible;
import static com.saucedemo.utils.Commands.fill;
import static com.saucedemo.utils.Commands.click;

import com.saucedemo.pages.LoginPages;

public class LoginActions extends LoginPages {

	public LoginActions(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void go() {
		isVisible(imgHomeSite);
	}

	public void fillCredentials(String userName, String password) {
		fill(iptUsrName, userName);
		fill(iptPassword, password);
		click(btnSubmit);
	}

	public void beLogged() {
		assertion(loggedTitle, "Products");
	}

	public void displaysTheError(String msg) {
		assertion(msgError, msg);
	}
}