package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
//	Zadatak (Za vezbanje)
//		Ucitati stranicu https://cms.demo.katalon.com/
//			Maksimizovati prozor
//			Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//			Prostavite duzinu prozora na 700px i visinu na 700px
//			Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://cms.demo.katalon.com/");
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//*[text()='Menu']")).isDisplayed()) {
			System.out.println("Is visible");
		} else {
			System.out.println("Not visible");
		}
		driver.manage().window().setSize(new Dimension(700, 700));
		if (driver.findElement(By.xpath("//*[text()='Menu']")).isDisplayed()) {
			System.out.println("Is visible");
		} else {
			System.out.println("Not visible");
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
