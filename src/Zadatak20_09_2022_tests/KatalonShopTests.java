package Zadatak20_09_2022_tests;

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

import Zadatak20_09_2022_pages.CartPage;
import Zadatak20_09_2022_pages.NavPage;
import Zadatak20_09_2022_pages.ProductPage;
import p20_09_2022_pages.BootstrapTablePage;
import p20_09_2022_pages.DeleteDialogPage;
import p20_09_2022_pages.EditDialogPage;

public class KatalonShopTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private NavPage navPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private String baseUrl = "https://cms.demo.katalon.com";
	private SoftAssert softAssert;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		productPage = new ProductPage(driver, wait);
		navPage = new NavPage(driver, wait);
		cartPage = new CartPage(driver, wait);
		softAssert = new SoftAssert();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@Test(priority = 10)
	public void addingProductWithQuantityToTheCart() {
		driver.get(baseUrl + "/product/flying-ninja/");

		productPage.getQuantityInput().clear();
		productPage.getQuantityInput().sendKeys("3");
		productPage.getAddToCartButton().click();
		softAssert.assertEquals(productPage.getAddToCartMessage().getText(), "�Flying Ninja�",
				"Message error should contains �Flying Ninja�");
		navPage.getCartLink().click();
		Assert.assertTrue(navPage.getCurrentUrl().contains("/cart"), "Url should contain /cart");
		Assert.assertEquals(cartPage.getRowsTable().size(), 1, "Number of products should be 1");
	}

	@Test(priority = 20)
	public void removingProductFromCart() throws InterruptedException {
		navPage.getCartLink().click();
		Assert.assertTrue(navPage.getCurrentUrl().contains("/cart"), "Url should contain /cart");
		Assert.assertEquals(cartPage.getRowsTable().size(), 1, "Number of products should be 1");
		cartPage.getDeleteButton(0).click();
		cartPage.waitForNumberOfProductRowsToBe(0);
		Assert.assertEquals(cartPage.getRowsTable().size(), 0, "Number of products should be 0");
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
