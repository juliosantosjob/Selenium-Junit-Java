package saucedemo.automation.e2e.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import saucedemo.automation.e2e.pages.PurchasesPages;
import saucedemo.automation.e2e.utils.Assertions;
import saucedemo.automation.e2e.utils.Commands;

public class PurchasesActions extends PurchasesPages {

    public PurchasesActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectItem(String nameProduct) {
        Commands.clickText(nameProduct);
        Assertions.contains(cardItem, nameProduct);
        Commands.clickText("Add to cart");
    }

    public void accessCart() {
        Commands.click(btnCart);
        Assertions.assertion(titleYourCart, "Your Cart");
    }

    public void displaysProductInCart(String nameProduct) {
        Assertions.isVisible(fieldProduct);
        Assertions.assertion(fieldProduct, nameProduct);
    }

    public void removeItem(String nameProduct) {
        Commands.clickText("Remove");
        Assertions.textNotDisplayed(nameProduct);
    }
}