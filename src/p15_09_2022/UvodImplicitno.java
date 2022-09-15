package p15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodImplicitno {

	public static void main(String[] args) throws InterruptedException {
//		 Zadatak
//		 Napisati program koji prijavljivanju na stranicu 
//		 http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox
//		(DOPUNA)
//		Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://cms.demo.katalon.com/my-account/");
		driver.findElement(By.id("username")).sendKeys("milan");

//		I nacin provere da li element postoji
//		List<WebElement> lista = driver.findElements(By.tagName("a"));
//		if (lista.size() == 0) {
//			System.out.println("Nije se pojavio nijedan element");
//		} else {
//			System.out.println("Pojavio se element");
//		}
		boolean elementPostoji = true;
		try {
			driver.findElement(By.tagName("a"));
		} catch (NoSuchElementException error) {
			elementPostoji = false;
		}
		if (elementPostoji) {
			System.out.println("Element postoji");
		} else {
			System.out.println("Element ne postoji");
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
