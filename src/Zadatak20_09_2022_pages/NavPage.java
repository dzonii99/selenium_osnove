package Zadatak20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getCartLink() {
		return driver.findElement(By.className("page-item-8")).findElement(By.tagName("a"));
	}

	public WebElement getCheckoutLink() {
		return driver.findElement(By.className("page-item-9")).findElement(By.tagName("a"));
	}

	public WebElement getMyAccountLink() {
		return driver.findElement(By.className("page-item-10")).findElement(By.tagName("a"));
	}

	public WebElement getSamplePageLink() {
		return driver.findElement(By.className("page-item-2")).findElement(By.tagName("a"));
	}

	public WebElement getShopLink() {
		return driver.findElement(By.className("page-item-7")).findElement(By.tagName("a"));
	}

}
