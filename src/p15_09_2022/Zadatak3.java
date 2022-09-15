package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
////		Zadatak 
//		Napisati program koji:
//			Ucitava stranicu  https://www.ebay.com/
//			Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
//			Zatim bira random element iz niza opcija koristeci Random. Vodite racuna da random element bude u opsegu broja elemenata niza. Random podsetnik
//			Selektuje random kategoriju izabranu u koraku iznad
//			Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Random random = new Random();

		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);

		Select select = new Select(driver.findElement(By.id("gh-cat")));
		List<WebElement> sve = select.getOptions();
		int x = random.nextInt(sve.size());
		select.selectByIndex(x);

		Thread.sleep(3000);
		driver.quit();

	}

}
