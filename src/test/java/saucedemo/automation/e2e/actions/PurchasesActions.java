package saucedemo.automation.e2e.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import saucedemo.automation.e2e.pages.PurchasesPages;

import static saucedemo.automation.e2e.utils.Assertions.*;
import static saucedemo.automation.e2e.utils.Commands.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static saucedemo.automation.e2e.utils.Assertions.textNotDisplayed;

public class PurchasesActions extends PurchasesPages {

    public PurchasesActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCart(String nameProduct) {
        clickText(nameProduct);
        contains(cardItem, nameProduct);
        clickText("Add to cart");
    }

    public void accessCart() {
        click(btnCart);
        assertion(titleYourCart, "Your Cart");
    }

    public void isDisplayed(String nameProduct) {
        isVisible(fieldProduct);
        assertEquals(fieldProduct.getText(), nameProduct);
    }

    public void removeItem() {
        clickText("Remove");
    }

    public void isNotDisplayed(String nameProduct) {
        textNotDisplayed(nameProduct);
    }
}