package com.saucedemo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.FunctionalLibrary;


public class LoginPage extends FunctionalLibrary {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement testErrorMsg;

	public WebElement getTestErrorMsg() {
		return testErrorMsg;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
