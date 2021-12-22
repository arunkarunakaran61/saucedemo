package com.saucedemo.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saucedemo.pom.PageobjectManager;
import com.saucedemo.utils.FunctionalLibrary;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SaucedemoSteps extends FunctionalLibrary {

	static PageobjectManager pom = new PageobjectManager();

	@Given("User on Sauce demo application")
	public void user_on_Demo_Blaze_application() throws Throwable {
		launchURL("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Assert.assertTrue(driver.getTitle().equals("Swag Labs"));
	}

	@When("User login application with credentials {string} and {string}")
	public void user_login_application_with_valid_credentials(String un, String pw) throws Throwable {
		elementSendKeys(pom.getLp().getUserName(), un);
		elementSendKeys(pom.getLp().getPassWord(), pw);
		elementClick(pom.getLp().getLoginBtn());
	}

	@Then("User verify Product Listing Page has products")
	public void user_verify_product_listing_page_has_products() throws Throwable {
		elementDisplayed(pom.getPl().getProductName().get(0));
	}

	@Then("User should see error message for invalid user")
	public void user_should_see_error_message_for_invalid_user() throws Exception {
		elementDisplayed(pom.getLp().getTestErrorMsg());
	}

	@When("User select a product {string} to add in cart bag")
	public void user_select_a_product_to_add_in_cart_bag(String val) {
		List<WebElement> productName = pom.getPl().getProductName();
		boolean flag = false;
		for (int i = 0; i < productName.size(); i++) {
			String text = productName.get(i).getText();
			if (text.equals(val)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}

	static String productName;

	@When("User select any product to cart and verify same product added")
	public void user_select_any_product_to_cart_and_verify_same_product_added() throws Exception {
		productName = pom.getPl().getProductName().get(0).getText();
		elementClick(pom.getPl().getProductName().get(0));
		Assert.assertTrue(pom.getPd().getProductPageProductName().getText().equals(productName));
		elementClick(pom.getPd().getAddtoCartBtnPdpage());
	}

	@When("User navigate to shopping cart page")
	public void user_navigate_to_shopping_cart_page() throws Exception {
		elementClick(pom.getPd().getShoppingCartLink());
	}

	@When("User verify the product added is correct")
	public void user_verify_the_product_added_is_correct() {
		Assert.assertTrue(pom.getCp().getInventoryName().getText().equals(productName));
	}

	@When("User add a product from cart to checkout page")
	public void user_add_a_product_from_cart_to_checkout_page() throws Exception {
		elementClick(pom.getCp().getCheckoutBtn());

	}

	@When("User enter checkout information {string}, {string} and {string}")
	public void user_enter_checkout_information(String fn, String ln, String code) throws Exception {
		elementSendKeys(pom.getCp().getFirstName(), fn);
		elementSendKeys(pom.getCp().getLastName(), ln);
		elementSendKeys(pom.getCp().getPostalCode(), code);
		elementClick(pom.getCp().getContinueBtn());
	}

	static List<String> inventoryPriceList = new ArrayList<String>();

	@When("User get all inventory price from Plp and remove dollar symbol")
	public void user_get_all_inventory_price_from_plp_remove_dollar_symbol() {
		List<WebElement> inventoryPrice = pom.getPl().getInventoryPrice();
		for (WebElement x : inventoryPrice) {
			inventoryPriceList.add(x.getText().replaceAll("$", ""));
		}
		System.out.println(inventoryPriceList);
	}

	@When("User click on individual page and verify the price same")
	public void user_click_on_individual_page_and_verify_the_price_same() throws Exception {
		List<WebElement> productNames = pom.getPl().getProductName();
		List<WebElement> inventoryPdPrice = pom.getPd().getInventoryPdPrice();
		for (int i = 0; i < productNames.size(); i++) {
			productNames.get(i).click();
			boolean equals = inventoryPdPrice.get(0).getText().replaceAll("$", "").equals(inventoryPriceList.get(i));
			Assert.assertTrue(equals);
			elementClick(pom.getPd().getBacktoProduct());
		}
	}

	@When("User click on place order and verify the success message")
	public void user_click_on_place_order_and_verify_same() throws Exception {
		elementClick(pom.getCp().getFinishBtn());
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", pom.getCp().getThankYouForOrder().getText());
	}

}
