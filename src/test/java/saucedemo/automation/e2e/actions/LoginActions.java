package saucedemo.automation.e2e.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import saucedemo.automation.e2e.pages.LoginPages;

import static saucedemo.automation.e2e.utils.Assertions.*;
import static saucedemo.automation.e2e.utils.Commands.*;

public class LoginActions extends LoginPages {
	private final WebDriver driver;

	public LoginActions(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public LoginActions go() {
		isVisible(imgHomeSite);

		return new LoginActions(driver);
	}

	public LoginActions fillCredentials(String userName, String password) {
		fill(iptUsrName, userName);
		fill(iptPassword, password);
		click(btnSubmit);

		return new LoginActions(driver);
	}

	public LoginActions beLogged() {
		isVisible(loggedTitle);
		assertion(loggedTitle, "Products");

		return new LoginActions(driver);
	}

	public String getError() {
		isVisible(msgError);

		return msgError.getText();
	}
}