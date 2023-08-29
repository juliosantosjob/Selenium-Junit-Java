package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasesPages {

	@FindBy(css = ".inventory_details_desc_container")
	protected WebElement cardItem;

	@FindBy(css = ".shopping_cart_link")
	protected WebElement btnCart;
	
	@FindBy(css = ".title")
	protected WebElement titleYourCart;

	@FindBy(xpath = "(//*[@class='inventory_item_name'])[1]")
	protected WebElement fieldProduct;
}