package com.saucedemo.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.saucedemo.utils.FunctionalLibrary;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends FunctionalLibrary {

	static Scenario scenario;

	@After
	public void afterHook(Scenario sc) {
		scenario=sc;
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs, "image/png", scenario.getName());
	}

}
