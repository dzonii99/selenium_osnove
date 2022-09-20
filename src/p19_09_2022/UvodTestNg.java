package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UvodTestNg {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://google.com");
	}

//	loginTest
	@Test(priority = 10)
	public void openHomePage() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";

		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title");

		String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		String expectedLang = "eng";

		Assert.assertEquals(actualLang, expectedLang, "ERROR: Language should be eng");

	}

	@Test(priority = 20)
	public void test2() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";

		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title");

		String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		String expectedLang = "eng";

		Assert.assertEquals(actualLang, expectedLang, "ERROR: Language should be eng");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
