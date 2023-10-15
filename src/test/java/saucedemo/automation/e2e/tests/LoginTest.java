package saucedemo.automation.e2e.tests;

import org.junit.jupiter.api.*;

import saucedemo.automation.e2e.actions.LoginActions;
import saucedemo.automation.e2e.support.Hooks;

import static saucedemo.automation.e2e.utils.Assertions.assertText;

@Tag("regression")
public class LoginTest extends Hooks {

    @BeforeEach
    public void hookBefore() {
        new LoginActions(driver)
                .go();
    }

    @Test
    @Tag("login")
    @DisplayName("Login successfully")
    public void loginSuccessfully() {
        new LoginActions(driver)
                .fillCredentials("standard_user", "secret_sauce")
                .beLogged();
    }

    @Test
    @Tag("username_error")
    @DisplayName("Login with wrong username")
    public void loginWithWrongUsername() {
        String error = new LoginActions(driver)
                .fillCredentials("un_error", "secret_sauce")
                .getError();

        assertText(error, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("passwd_error")
    @DisplayName("Login with wrong password")
    public void loginWithWrongPassword() {
        String error = new LoginActions(driver)
                .fillCredentials("standard_user", "un_error")
                .getError();

        assertText(error, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("both_error")
    @DisplayName("Login with wrong password and username")
    public void loginWithWrongPasswordAndUsername() {
        String error = new LoginActions(driver)
                .fillCredentials("", "")
                .getError();

        assertText(error, "Epic sadface: Username is required");
    }

}