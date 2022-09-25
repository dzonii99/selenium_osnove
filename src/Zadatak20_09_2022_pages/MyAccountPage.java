package Zadatak20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public MyAccountPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getLogInButton() {
		return driver.findElement(By.name("login"));
	}

	public WebElement getErrorMessage() {
		return driver.findElement(By.xpath("//*[@role='alert']/li"));
	}

	public WebElement getUsernameInput() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getWelcomeMessage() {
		return driver.findElement(By.xpath("//*[@class='woocommerce-MyAccount-content']/p[1]"));
	}

}
