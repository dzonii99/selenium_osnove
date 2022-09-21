package d19_09_2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class BootstrapTableTests {
	private WebDriver driver;
	private String baseUrl = "https://s.bootsnipp.com";
	private WebDriverWait wait;
	private String middleName = "Milosav";

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
	public void editRow() {
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Title should be Table with Edit and Update Data - Bootsnipp.com");
		driver.findElement(By.xpath("//*[contains(@class,'update')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("fn")).sendKeys("Zivadin");
		driver.findElement(By.id("ln")).clear();
		driver.findElement(By.id("ln")).sendKeys("Milosavljevic");
		driver.findElement(By.id("mn")).clear();
		driver.findElement(By.id("mn")).sendKeys("Milosav");
		driver.findElement(By.id("up")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit")));
		Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "Zivadin", "First name should be Zivadin");
		Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "Milosavljevic",
				"Last name should be Milosavljevic");
		Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "Milosav", "Middle name should be Milosav");
	}

	@Test(priority = 20)
	public void deleteRow() {
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Title should be Table with Edit and Update Data - Bootsnipp.com");
		driver.findElement(By.className("delete")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete")));
		Assert.assertTrue(driver.findElement(By.id("d1")).findElements(By.tagName("td")).size() == 0,
				"Row should be deleted");

	}

	@Test(priority = 30)
	public void takeAScreenshot() throws IOException {
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Title should be Table with Edit and Update Data - Bootsnipp.com");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("img/secondScreenshot.png"));
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
