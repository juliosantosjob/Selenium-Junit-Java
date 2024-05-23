package saucedemo.automation.e2e.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import saucedemo.automation.e2e.pages.LoginPages;

import static org.junit.Assert.assertEquals;
import static saucedemo.automation.e2e.utils.Assertions.*;
import static saucedemo.automation.e2e.utils.Commands.*;

public class LoginActions extends LoginPages {
	
	public LoginActions(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void openApp() {
		isVisible(imgHomeSite);
	}

	public void fillCreds(String userName, String password) {
		fill(iptUsrName, userName);
		fill(iptPassword, password);
		click(btnSubmit);
	}

	public void isLogged() {
		isVisible(loggedTitle);
		assertion(loggedTitle, "Products");
	}

	public void displaysError(String error) {
		isVisible(msgError);
		assertEquals(msgError.getText(), error);
	}
}