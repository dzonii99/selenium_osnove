package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		2. Zadatak (dok ne stignemo do ovog zadatka 
//		izguglajte kako da selektujete vrednost u select elementu)
//		Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);

		Select select = new Select(driver.findElement(By.id("gh-cat")));
		select.selectByValue("14339");

		Thread.sleep(3000);
		driver.quit();

	}

}
