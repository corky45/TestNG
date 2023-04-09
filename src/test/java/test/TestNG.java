package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;

	By ADD_FIELD = By.cssSelector("input[name=\"data\" i]");
	By ADD_BUTTON = By.cssSelector("input[value=\"Add\" ] ");
	By MONTH_DROPDOWN = By.cssSelector("select[name=\"due_month\"]");

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\clcra\\eclipse-workspace\\JUnitTest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://techfios.com/test/107/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//Test 1: Validate a user is able to add a category and once the category is added it should display.
	@Test
	public void addCategory() {
		String category = "Alm";
		driver.findElement(ADD_FIELD).sendKeys(category);
		driver.findElement(ADD_BUTTON).click();
	}

//Test 2: Validate a user is not able to add a duplicated category. 
//If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."
	@Test
	public void duplicateCategory() {
		String category = "Zika";

		driver.findElement(ADD_FIELD).sendKeys(category);
		driver.findElement(ADD_BUTTON).click();

		List<String> categories = new ArrayList<>();
		if (categories.contains(category)) {
			System.out.println("The category you want to add already exists: " + category);
		} else {
			categories.add(category);
		}
	}

//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	@Test
	public boolean monthDropDown() {
		WebElement dropdown = driver.findElement(By.cssSelector("select[name=\"due_month\"]"));
		List<WebElement> options = dropdown.findElements(By.tagName("option"));
		List<String> dropdownValues = new ArrayList<>();
		for (WebElement option : options) {
			dropdownValues.add(option.getAttribute("value"));
		}
		return dropdownValues.containsAll(options);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
