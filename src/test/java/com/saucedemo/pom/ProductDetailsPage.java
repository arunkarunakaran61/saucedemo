package com.saucedemo.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.FunctionalLibrary;

public class ProductDetailsPage extends FunctionalLibrary{
	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[@class='inventory_details_name large_size']")
	private WebElement productPageProductName;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addtoCartBtnPdpage;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement shoppingCartLink;

	@FindBy(id="back-to-products")
	private WebElement backtoProduct;
	
	public WebElement getBacktoProduct() {
		return backtoProduct;
	}


	@FindBy(xpath="//div[@class='inventory_details_price']")
	private List<WebElement> inventoryPdPrice;
	
	public List<WebElement> getInventoryPdPrice() {
		return inventoryPdPrice;
	}
	
	public WebElement getProductPageProductName() {
		return productPageProductName;
	}

	public WebElement getAddtoCartBtnPdpage() {
		return addtoCartBtnPdpage;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	
	
		
}
