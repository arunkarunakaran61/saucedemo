package com.saucedemo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.FunctionalLibrary;



public class CheckOutPage extends FunctionalLibrary {

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement inventoryName;

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(id = "postal-code")
	private WebElement postalCode;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	private WebElement thankYouForOrder;
	
	public WebElement getThankYouForOrder() {
		return thankYouForOrder;
	}
	public WebElement getInventoryName() {
		return inventoryName;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getFinishBtn() {
		return finishBtn;
	}

}
