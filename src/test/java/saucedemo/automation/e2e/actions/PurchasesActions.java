package saucedemo.automation.e2e.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import saucedemo.automation.e2e.pages.PurchasesPages;

import static saucedemo.automation.e2e.utils.Assertions.*;
import static saucedemo.automation.e2e.utils.Commands.*;

public class PurchasesActions extends PurchasesPages {
    private final WebDriver driver;

    public PurchasesActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PurchasesActions addToCart(String nameProduct) {
        clickText(nameProduct);
        contains(cardItem, nameProduct);
        clickText("Add to cart");

        return new PurchasesActions(driver);
    }

    public PurchasesActions accessCart() {
        click(btnCart);
        assertion(titleYourCart, "Your Cart");

        return new PurchasesActions(driver);
    }

    public String getNameProductInCart() {
        isVisible(fieldProduct);

        return fieldProduct.getText();
    }

    public void removeItem() {
        clickText("Remove");
    }
}