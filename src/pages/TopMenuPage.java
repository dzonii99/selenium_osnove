package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getWomenLink() {
		return driver.findElement(By.xpath("//*[contains(@class,'sf-menu')]/li[1]/a"));
	}

	public WebElement getDressesLink() {
		return driver.findElement(By.xpath("//*[contains(@class,'sf-menu')]/li[2]/a"));
	}

	public WebElement getTshirtsLink() {
		return driver.findElement(By.xpath("//*[contains(@class,'sf-menu')]/li[3]/a"));
	}

	public WebElement getWomenMenu() {
		return driver.findElement(By.xpath("//*[contains(@class,'sf-menu')]/li[1]/ul"));
	}

	public WebElement getDressesMenu() {
		return driver.findElement(By.xpath("//*[contains(@class,'sf-menu')]/li[2]/ul"));
	}

}
