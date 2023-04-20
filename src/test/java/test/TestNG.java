package test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TestNg;
import util.BrowserFactory;

public class TestNG extends BrowserFactory {
	WebDriver driver;
	TestNg testng;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.initDriver();
	}

//Test 1: Validate a user is able to add a category and once the category is added it should display.
	@Test
	public void addCategory() {
		String category = "SLC";
		testng = PageFactory.initElements(driver, TestNg.class);
		testng.addCategory(category);
	}

//Test 2: Validate a user is not able to add a duplicated category. 
//If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."
	@Test
	public void duplicateCategory() {
		String category = "SDMC";
		TestNg testng = PageFactory.initElements(driver, TestNg.class);
		testng.duplicateCategory(category);
	}

//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	@Test
	public void monthDropDown() {
		TestNg testng = PageFactory.initElements(driver, TestNg.class);
		testng.monthDropDown();
	}

	@After
	public void tear() {
		tearDown();
	}
}
