package saucedemo.automation.e2e.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import saucedemo.automation.e2e.actions.LoginActions;
import saucedemo.automation.e2e.actions.PurchasesActions;
import saucedemo.automation.e2e.support.Hooks;

@Tag("regression")
public class PurchasesTest extends Hooks {
    public static LoginActions login;
    public static PurchasesActions purchases;
    private final String product = "Sauce Labs Bike Light";

    @BeforeEach
    public void hooks() {
        /* Ação de login para realizar os proximos cenarios */

        login.doLogin("standard_user", "secret_sauce");
    }

    @Test
    @Tag("add_product")
    @DisplayName("Adding product to cart")
    public void addingProductToTheCart() {
        purchases.addToCart(product);
        purchases.accessCart();
        purchases.isDisplayed(product);
    }

    @Test
    @Tag("rmv_product")
    @DisplayName("Remove product to cart")
    public void removeProductToCart() {
        purchases.addToCart(product);
        purchases.accessCart();
        purchases.removeItem();
        purchases.isNotDisplayed(product);
    }

}
