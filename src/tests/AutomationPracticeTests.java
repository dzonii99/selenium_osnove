package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BuyBoxPage;
import pages.HeaderPage;
import pages.LayerCartPage;
import pages.TopMenuPage;

public abstract class AutomationPracticeTests {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "http://automationpractice.com/";
	protected BuyBoxPage buyBoxPage;
	protected HeaderPage headerPage;
	protected LayerCartPage layerCartPage;
	protected TopMenuPage topMenuPage;
	protected SoftAssert softAssert;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		buyBoxPage = new BuyBoxPage(driver, wait);
		headerPage = new HeaderPage(driver, wait);
		layerCartPage = new LayerCartPage(driver, wait);
		topMenuPage = new TopMenuPage(driver, wait);
		softAssert = new SoftAssert();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
