package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class TestNg {
	WebDriver driver;

	public TestNg(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(xpath = "//input[@name ='data']")
	WebElement ADD_FIELD;
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/input[2]")
	WebElement ADD_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[3]")
	String MONTH_DROPDOWN;
	@FindBy(xpath = "/html/body/text()")
	WebElement DUPLICATE_CATEGORY_MSG;

	public void addCategory(String category) {
		ADD_FIELD.sendKeys(category);
		ADD_BUTTON.click();
		Assert.assertTrue("Category added", ADD_FIELD.isDisplayed());
	}

	// Test 2: Validate a user is not able to add a duplicated category.
	// If it does then the following message will display: "The category you want to
	// add already exists: <duplicated category name>."
	@SuppressWarnings("deprecation")
	public void duplicateCategory(String category) {
		ADD_FIELD.sendKeys(category);
		ADD_BUTTON.click();
		Assert.assertEquals(category, DUPLICATE_CATEGORY_MSG, "The category you want to add already exists:" + category);
	}

	// Test 3: Validate the month drop down has all the months (jan, feb, mar ...)
	// in the Due Date dropdown section.
	public void monthDropDown() {
		String before_xpath = "//*[@id='extra']/select[3]/option[";
		String after_xpath = "]";
		for(int i=2; i <= 13; i++) {
			String months = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(months);
		}
		
				
	}

}