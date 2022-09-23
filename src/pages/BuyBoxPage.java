package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}

	public Select getSizeSelect() {
		Select select = new Select(driver.findElement(By.id("group_1")));
		return select;
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("Submit"));
	}

	public WebElement getWishListButton() {
		return driver.findElement(By.id("wishlist_button"));
	}

	public WebElement getProductPrice() {
		return driver.findElement(By.id("our_price_display"));
	}

	public WebElement getColor(String boja) {
		List<WebElement> boje = driver.findElements(By.xpath("//*[@id='color_to_pick_list']/li/a"));
		WebElement glavnaBoja = boje.get(0);
		for (int i = 0; i < boje.size(); i++) {
			if (boje.get(i).getAttribute("title").equals(boja)) {
				glavnaBoja = boje.get(i);
			}
		}
		return glavnaBoja;

	}

	public void scrollToTheElement() {
		WebElement buyBox = driver.findElement(By.className("page-product-box"));
		new Actions(driver).scrollToElement(buyBox).perform();
	}

}
