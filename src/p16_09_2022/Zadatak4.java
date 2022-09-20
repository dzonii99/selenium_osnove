package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak4 {

	public static void main(String[] args) {
//		.Zadatak
//		Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV i ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://s.bootsnipp.com/iframe/klDWV");
		wait.until(ExpectedConditions.textToBe(By.id("precent"), "100%"));
//		wait.until(ExpectedConditions.attributeContains(By.className("glow"), "style", "width: 100%;"));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader-wrap")));
		System.out.println("Completed!");
		driver.quit();
	}

}
