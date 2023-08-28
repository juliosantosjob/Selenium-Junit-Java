package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static utils.Assertions.assertion;
import static utils.Assertions.isVisible;
import static utils.Commands.fill;
import static utils.Commands.click;

import pages.LoginPages;

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