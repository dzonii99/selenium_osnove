package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodSeleniumLista {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://cms.demo.katalon.com/");

		List<WebElement> links = driver.findElements(By.xpath("//*[@id='primary-menu']//a"));

		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
