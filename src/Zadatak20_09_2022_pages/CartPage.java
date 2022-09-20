package Zadatak20_09_2022_pages;

import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getDeleteButton(int row) {
		return driver.findElements(By.className("remove")).get(row);
	}

	public WebElement getCouponInput() {
		return driver.findElement(By.id("coupon_code"));
	}

	public WebElement getApplyCouponButton() {
		return driver.findElement(By.name("apply_coupon"));
	}

	public WebElement getUpdateCartButton() {
		return driver.findElement(By.name("update_cart"));
	}

	public List<WebElement> getRowsTable() {
		return driver.findElements(By.xpath("//*[@class='woocommerce-cart-form__cart-item cart_item']"));
	}

	public void waitForNumberOfProductRowsToBe(int productNum) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), productNum));
	}
}
