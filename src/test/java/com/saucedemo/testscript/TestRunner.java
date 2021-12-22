package com.saucedemo.testscript;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.saucedemo.utils.FunctionalLibrary;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "json:Reports\\cucumber.json"},
			features = {"src\\test\\java\\com\\saucedemo\\feature"},
		glue = {"com.saucedemo.stepdefinition"},
		tags = "@saucedemo",
		monochrome=true,
		dryRun=false
		)

public class TestRunner extends FunctionalLibrary{
	
	static boolean browserFlag = true;
	@BeforeClass
	public static void browserSetup() throws Exception {
		if (browserFlag) {
			browser_LaunchIgnoreCase("chrome");
		}
	}
	
	@AfterClass
	public static void generateReport() {
		if (browserFlag) {
			driver.quit();

		}
		FunctionalLibrary.generateReport();
		
	}

}
