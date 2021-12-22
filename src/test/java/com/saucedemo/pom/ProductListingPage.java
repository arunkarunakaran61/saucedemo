package com.saucedemo.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.FunctionalLibrary;


public class ProductListingPage extends FunctionalLibrary {

	public ProductListingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<WebElement> productName;

	@FindBy(xpath = "add-to-cart-sauce-labs-backpack")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']//ancestor::div[@class='inventory_item_description']//button")
	private WebElement sauceLabBoltTshirtProductAddtoCartBtn;

	@FindBy(xpath="//div[@class='inventory_item_price']")
	private List<WebElement> inventoryPrice;
	
	public List<WebElement> getInventoryPrice() {
		return inventoryPrice;
	}

	public List<WebElement> getProductName() {
		return productName;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getSauceLabBoltTshirtProductAddtoCartBtn() {
		return sauceLabBoltTshirtProductAddtoCartBtn;
	}

}
