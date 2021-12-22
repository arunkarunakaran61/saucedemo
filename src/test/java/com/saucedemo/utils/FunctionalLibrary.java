package com.saucedemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class FunctionalLibrary {
	public static WebDriver driver;

	public static WebDriver browser_LaunchIgnoreCase(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

			else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Is not a valid browser");
		}
		return driver;

	}

	public static void launchURL(String url) throws Exception {
		try {
			driver.get(url);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception("URL is incorrect");
		}
		driver.manage().window().maximize();

	}

	public static void elementClick(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 10);
			wb.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			// e.printStackTrace();
			// throw new Exception("Element is not clickable");
			elementClickUsingJS(element);
		}
	}

	public static void elementDisplayed(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 10);
			wb.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not Displayed");
		}
	}

	public static void elementClear(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to clear the text in the webelement");
		}
	}

	public static void elementSendKeys(WebElement element, String value) throws Exception {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the webelement");
		}
	}

	public static void elementClickUsingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// public static void elementsendkeyesUsingJS(WebElement element, String value)
	// {
	// JavascriptExecutor executor=(JavascriptExecutor) driver;
	// executor.executeAsyncScript("arguments[0].sendkeys();", element);

	public static void javascriptSendKeys(WebElement element, String Value) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + Value + "';", element);
	}

	public static String getElementText(WebElement element) throws Exception {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}
	}

	public static String getElementAttribute(WebElement element, String value) throws Exception {
		try {
			String attribute = element.getAttribute(value);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}
	}

	/*
	 * public void selectByIndex(WebElement element, S i, String options) throws
	 * Exception { try { Select s = new Select(element); if (s.equals(options)) {
	 * s.selectByValue(value); }else if (s.equals("index")) {
	 * 
	 * } s.selectByIndex(i); } catch (Exception e) { e.printStackTrace(); throw new
	 * Exception("Unable to select the option from dropdown"); } }
	 * 
	 * public void selectByValue(WebElement element, String value) throws Exception
	 * { try { Select s = new Select(element); } catch (Exception e) {
	 * e.printStackTrace(); throw new
	 * Exception("Unable to select the option from dropdown"); } }
	 * 
	 * public void selectByVisibleText(WebElement element, String value) throws
	 * Exception { try { Select s = new Select(element);
	 * s.selectByVisibleText(value); } catch (Exception e) { e.printStackTrace();
	 * throw new Exception("Unable to select the option from dropdown"); } }
	 */

	public static void selectDropDown(WebElement element, String options, String value) {

		Select sc = new Select(element);
		if (options.equals("value")) {
			sc.selectByValue(value);
		} else if (options.equals("index")) {
			sc.selectByIndex(Integer.parseInt(value));
		} else if (options.equals("visibletext")) {
			sc.selectByVisibleText(value);
		}

	}

	public static void moveToElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(element).build().perform();
			;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void actionClickElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.click(element).build().perform();
			;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void actionSendKeysElement(WebElement element, String value) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.sendKeys(element, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send text to the webelement");
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send text to the webelement");
		}
	}

	public static void doubleClickElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.doubleClick(element).build().perform();
			;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void contextClickElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void waitUntilElementVisibility(WebElement element) throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not visible");
		}
	}

	public static void waitUntilAlertPresent() throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Alert is not present");
		}
	}

	public static void acceptAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to accept the alert");
		}
	}

	public static void dismissAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to dismiss the alert");
		}
	}

	public static void sendKeysToAlert(String value) throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the alert");
		}
	}

	public static void generateReport() {
		File reportOutputDirectory = new File(System.getProperty("user.dir") + "\\Reports");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(System.getProperty("user.dir") + "\\Reports\\cucumber.json");

		String buildNumber = "1";
		String projectName = "cucumberProject";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
	}

	public static String getObjectRepo(String obj) throws Exception {
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\demoblaze\\pom\\ObjectRepo.properties");
		FileInputStream fin = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fin);
		return String.valueOf(prop.get(obj));
	}
}
