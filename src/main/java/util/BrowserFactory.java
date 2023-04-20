package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	 static WebDriver driver;

	public static WebDriver initDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\clcra\\eclipse-workspace\\TestNGProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://techfios.com/test/107/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}