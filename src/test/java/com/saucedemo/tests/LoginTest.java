package com.saucedemo.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.saucedemo.actions.LoginActions;
import com.saucedemo.support.Hooks;

@Tag("regression")
public class LoginTest extends Hooks {
    private static LoginActions login;

    @BeforeEach
    public void hook() {
        login = new LoginActions(driver);
        login.go();
    }

    @Test
    @Tag("login")
    @DisplayName("Login successfully")
    public void loginSuccessfully() {
        login.fillCredentials("standard_user", "secret_sauce");
        login.beLogged();
    }

    @Test
    @Tag("usernameError")
    @DisplayName("Login with wrong username")
    public void loginWithWrongUsername() {
        login.fillCredentials("un_error", "secret_sauce");
        login.displaysTheError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("passwdError")
    @DisplayName("Login with wrong password")
    public void loginWithWrongPassword() {
        login.fillCredentials("standard_user", "un_error");
        login.displaysTheError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("bothError")
    @DisplayName("Login with wrong password and username")
    public void loginWithWrongPasswordAndUsername() {
        login.fillCredentials("", "");
        login.displaysTheError("Epic sadface: Username is required");
    }
    
}