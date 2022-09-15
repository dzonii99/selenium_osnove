package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		 Zadatak
//		 Napisati program koji prijavljivanju na stranicu 
//		 http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox
//		(DOPUNA)
//		Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cms.demo.katalon.com/my-account/");
		Thread.sleep(1000);
		driver.findElement(By.id("rememberme")).click();
		if (driver.findElement(By.id("rememberme")).isSelected()) {
			System.out.println("The checkbox is selected");
		} else {
			System.out.println("The checkbox is not selected");
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
