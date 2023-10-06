package com.saucedemo.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.saucedemo.actions.PurchasesActions;
import com.saucedemo.actions.LoginActions;
import com.saucedemo.support.Hooks;

@Tag("regression")
public class PurchasesTest extends Hooks {
    private static PurchasesActions toCart;
    private static LoginActions login;

    @BeforeEach
    public void hook() {
        toCart = new PurchasesActions(driver);
        login = new LoginActions(driver);

        /* Ação de login para realizar os proximos cenarios */
        login.go();
        login.fillCredentials("standard_user", "secret_sauce");
    }

    @Test
    @Tag("addProduct")
    @DisplayName("Adding product to cart")
    public void addingProductToTheCart() {
        toCart.selectItem("Sauce Labs Bike Light");
        toCart.accessCart();
        toCart.displaysProductInCart("Sauce Labs Bike Light");
    }

    @Test
    @Tag("rmvProduct")
    @DisplayName("Remove product to cart")
    public void removeProductToCart() {
        toCart.selectItem("Sauce Labs Bike Light");
        toCart.accessCart();
        toCart.displaysProductInCart("Sauce Labs Bike Light");
        toCart.removeItem("Sauce Labs Bike Light");
    }
    
}