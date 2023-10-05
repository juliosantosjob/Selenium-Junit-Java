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
    private static PurchasesActions toCart;
    private static LoginActions login;

    @BeforeEach
    public void hook() {
        toCart = new PurchasesActions(driver);
        login = new LoginActions(driver);

        /* Adicionando um passo de login para cada teste */
        login.go();
        login.fillCredentials("standard_user", "secret_sauce");
    }

    @Test
    @Tag("addProduct")
    @DisplayName("Adding product to cart")
    public void adding_product_to_the_cart() {
        toCart.selectItem("Sauce Labs Bike Light");
        toCart.accessCart();
        toCart.displaysProductInCart("Sauce Labs Bike Light");
    }

    @Test
    @Tag("rmvProduct")
    @DisplayName("Remove product to cart")
    public void remove_product_to_cart() {
        toCart.selectItem("Sauce Labs Bike Light");
        toCart.accessCart();
        toCart.displaysProductInCart("Sauce Labs Bike Light");
        toCart.removeItem("Sauce Labs Bike Light");
    }
    
}
