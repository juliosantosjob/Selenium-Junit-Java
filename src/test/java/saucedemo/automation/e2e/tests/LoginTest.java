package saucedemo.automation.e2e.tests;

import org.junit.jupiter.api.*;
import saucedemo.automation.e2e.actions.LoginActions;
import saucedemo.automation.e2e.support.Hooks;

@Tag("regression")
public class LoginTest extends Hooks {
    public static LoginActions login;

    @BeforeEach
    public void hooks() {
        login = new LoginActions(driver);
    }

    @Test
    @Tag("login")
    @DisplayName("Login successfully")
    public void loginSuccessfully() {
        login.openApp();
        login.fillCreds("standard_user", "secret_sauce");
        login.isLogged();
    }

    @Test
    @Tag("username_error")
    @DisplayName("Login with wrong username")
    public void loginWithWrongUsername() {
        login.openApp();
        login.fillCreds("un_error", "secret_sauce");
        login.displaysError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("passwd_error")
    @DisplayName("Login with wrong password")
    public void loginWithWrongPassword() {
        login.openApp();
        login.fillCreds("standard_user", "un_error");
        login.displaysError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("both_error")
    @DisplayName("Login with wrong password and username")
    public void loginWithWrongPasswordAndUsername() {
        login.openApp();
        login.fillCreds("", "");
        login.displaysError("Epic sadface: Username is required");
    }
}