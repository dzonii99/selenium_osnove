package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.className("continue"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.className("button-medium"));
	}

	public WebElement getAttributesOfElements() {
		return driver.findElement(By.id("layer_cart_product_attributes"));
	}

	public WebElement getQuantityNumber() {
		return driver.findElement(By.id("layer_cart_product_quantity"));
	}

	public WebElement getTotalPriceElement() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}

	public void waitForMessageToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));

	}

	public void waitForMessageToBeInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}

}
