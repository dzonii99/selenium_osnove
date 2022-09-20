package p19_08_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonLoginTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";

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
		driver.get(baseUrl);

	}

	@Test(priority = 10)
	public void visitLoginPageFromNavBar() {
		driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account – Katalon Shop";
		Assert.assertEquals(actualTitle, expectedTitle, "Title should be My account – Katalon Shop");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("/my-account"), "Url should contains /my-account");
	}

	@Test(priority = 20)
	public void checkInputTypes() {
		driver.get(baseUrl + "/my-account");
		Assert.assertTrue(driver.findElement(By.name("username")).getAttribute("type").equals("text"),
				"Email should be text type");
//		Assert.assertEquals(driver.findElement(By.name("username")).getAttribute("type"), "text",
//				"Email should be text type");
		Assert.assertTrue(driver.findElement(By.name("password")).getAttribute("type").equals("password"),
				"Password should be password type");
		Assert.assertTrue(driver.findElement(By.id("rememberme")).getAttribute("type").equals("checkbox"),
				"Checkbox should be checkbox type");
		Assert.assertFalse(driver.findElement(By.id("rememberme")).isSelected(), "Remember me should be unselected");

	}

	@Test(priority = 30)
	public void displayErrorWhenCredentialsAreWrong() {
		String email = "invalidemail@gmail.com";
		String password = "invalid123";
		driver.get(baseUrl + "/my-account");
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
//		boolean prisutan = true;
//		try {
//			driver.findElement(By.xpath("//*[@role='alert']"));
//		} catch (Exception e) {
//			prisutan = false;
//		}
//		Assert.assertTrue(prisutan, "Error should exist on the site");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='alert']")));
		Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
				"ERROR: Invalid email address. Lost your password?",
				"Error is not displayed when credentials are invalid.");
//		Assert.assertTrue(driver.findElement(By.xpath("//*[@role='alert']")).isDisplayed(), "Error should be visible");
		String afterErrorUrl = driver.getCurrentUrl();
		Assert.assertTrue(afterErrorUrl.contains("/my-account"), "Url should contains /my-account");
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void exit() {
		driver.quit();
	}
}
