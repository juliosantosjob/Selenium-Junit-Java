package saucedemo.automation.e2e.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import saucedemo.automation.e2e.actions.PurchasesActions;
import saucedemo.automation.e2e.actions.LoginActions;
import saucedemo.automation.e2e.support.Hooks;

import static saucedemo.automation.e2e.utils.Assertions.assertText;
import static saucedemo.automation.e2e.utils.Assertions.textNotDisplayed;

@Tag("regression")
public class PurchasesTest extends Hooks {
    private final String product = "Sauce Labs Bike Light";

    @BeforeEach
    public void hookBefore() {
        /* Ação de login para realizar os proximos cenarios */
        new LoginActions(driver)
                .go()
                .fillCredentials("standard_user", "secret_sauce")
                .beLogged();
    }

    @Test
    @Tag("add_product")
    @DisplayName("Adding product to cart")
    public void addingProductToTheCart() {
        String name = new PurchasesActions(driver)
                .addToCart(product)
                .accessCart()
                .getNameProductInCart();

        assertText(name, product);
    }

    @Test
    @Tag("rmv_product")
    @DisplayName("Remove product to cart")
    public void removeProductToCart() {
        new PurchasesActions(driver)
                .addToCart(product)
                .accessCart()
                .removeItem();

        textNotDisplayed(product);
    }

}