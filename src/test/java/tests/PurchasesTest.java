package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import actions.PurchasesActions;
import actions.LoginActions;
import support.Hooks;

@Tag("regression")
public class PurchasesTest extends Hooks {
    private static PurchasesActions addToCart;
    private static LoginActions login;

    @BeforeEach
    public void hook() {
        addToCart = new PurchasesActions(driver);
        login = new LoginActions(driver);

        /* Adicionando um passo de login para cada teste */
        login.go();
        login.fillCredentials("standard_user", "secret_sauce");
    }

    @Test
    @Tag("addProduct")
    @DisplayName("Adding product to cart")
    public void addingAProductToTheCart() {
        addToCart.selectItem("Sauce Labs Bike Light");
        addToCart.accessCart();
        addToCart.displaysProductInCart("Sauce Labs Bike Light");
    }

    @Test
    @Tag("removeProduct")
    @DisplayName("Remove product to cart")
    public void removeAProductToTheCart() {
        addToCart.selectItem("Sauce Labs Bike Light");
        addToCart.accessCart();
        addToCart.displaysProductInCart("Sauce Labs Bike Light");
        addToCart.removeItem("Sauce Labs Bike Light");
    }
}