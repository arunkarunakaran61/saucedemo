package com.saucedemo.pom;

public class PageobjectManager {

	private LoginPage lp;
	private CheckOutPage cp;
	private ProductDetailsPage pd;
	private ProductListingPage pl;

	public LoginPage getLp() {
		if (lp == null) {
			lp = new LoginPage();
		}
		return lp;
	}

	public CheckOutPage getCp() {
		if (cp == null) {
			cp = new CheckOutPage();
		}
		return cp;
	}

	public ProductDetailsPage getPd() {
		if (pd == null) {
			pd = new ProductDetailsPage();
		}
		return pd;
	}

	public ProductListingPage getPl() {
		if (pl == null) {
			pl = new ProductListingPage();
		}
		return pl;
	}

}
