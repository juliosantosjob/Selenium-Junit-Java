package com.saucedemo.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.saucedemo.utils.Assertions.textNotDisplayed;
import static com.saucedemo.utils.Assertions.isVisible;
import static com.saucedemo.utils.Assertions.assertion;
import static com.saucedemo.utils.Assertions.contains;

import static com.saucedemo.utils.Commands.click;
import static com.saucedemo.utils.Commands.clickText;

import com.saucedemo.pages.PurchasesPages;

public class PurchasesActions extends PurchasesPages {

    public PurchasesActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectItem(String nameProduct) {
        clickText(nameProduct);
        contains(cardItem, nameProduct);
        clickText("Add to cart");
    }

    public void accessCart() {
        click(btnCart);
        assertion(titleYourCart, "Your Cart");
    }

    public void displaysProductInCart(String nameProduct) {
        isVisible(fieldProduct);
        assertion(fieldProduct, nameProduct);
    }

    public void removeItem(String nameProduct) {
        clickText("Remove");
        textNotDisplayed(nameProduct);
    }
}