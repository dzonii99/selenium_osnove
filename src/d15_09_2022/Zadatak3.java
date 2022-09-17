package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak (Za vezbanje)
//		Napisati program koji 
//		Ucitava https://seeds.sproutsocial.com/components/loader-button/
//		Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
//		Klikce ne dugme 
//		Ceka da dugme zavrsi sa loadingom 
//		Ispisati poruku na ekranu
//		Zatvoriti pretrazivac
//		HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		new Actions(driver)
				.moveToElement(driver.findElement(By.xpath(
						"//*[text()='Loader buttons are used to display a loading indicator inside of a button.']")))
				.perform();
		Thread.sleep(3000);
		driver.findElement(By.className("dzjEcK")).click();
		Thread.sleep(3000);
		boolean dugme = true;
		try {
//			driver.findElement(By.xpath("//*[@data-qa-button-isloading='false']"));
			driver.findElement(By.className("dzjEcK")).getAttribute("data-qa-button-isloading").equals("false");
		} catch (Exception e) {
			dugme = false;
		}
		if (dugme) {
			System.out.println("Ucitano je dugme");
		} else {
			System.out.println("Dugme nije ucitano");
		}

		driver.quit();

	}

}
