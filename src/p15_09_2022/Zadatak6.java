package p15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Ucitati stranicu https://demoqa.com/modal-dialogs
//			Kliknuti na dugme Large modal
//			Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke
// 		li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/modal-dialogs");
		driver.findElement(By.id("showLargeModal")).click();
		boolean tekst = true;
		try {
			driver.findElement(By.id("example-modal-sizes-title-lg"));
		} catch (Exception e) {
			tekst = false;
		}
		if (tekst) {
			System.out.println("Pojavio se");
		} else {
			System.out.println("Nije se pojavilo");
		}

		driver.quit();

	}

}
