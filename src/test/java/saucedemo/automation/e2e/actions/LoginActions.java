package saucedemo.automation.e2e.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import saucedemo.automation.e2e.pages.LoginPages;
import saucedemo.automation.e2e.utils.Assertions;
import saucedemo.automation.e2e.utils.Commands;

public class LoginActions extends LoginPages {

	public LoginActions(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void go() {
		Assertions.isVisible(imgHomeSite);
	}

	public void fillCredentials(String userName, String password) {
		Commands.fill(iptUsrName, userName);
		Commands.fill(iptPassword, password);
		Commands.click(btnSubmit);
	}

	public void beLogged() {
		Assertions.assertion(loggedTitle, "Products");
	}

	public void displaysTheError(String msg) {
		Assertions.assertion(msgError, msg);
	}
}