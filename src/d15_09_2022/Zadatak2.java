package d15_09_2022;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//		Bira Country, State i City po vasoj zelji
//		Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//		I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//		Izabrerit Country, State i City tako da imate podatke da selektujete!

//		Zamena cisto da isprobam
		Random random = new Random();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");

		Select s1 = new Select(driver.findElement(By.id("country_code")));
		List<WebElement> country = s1.getOptions();
		s1.selectByIndex(randomBroj(1, country.size()));
		boolean loading = true;
		if (driver.findElement(By.id("msg")).getAttribute("style").equals("display: block;")) {
			try {
				driver.findElement(By.id("msg")).getAttribute("style").equals("display: none;");
			} catch (Exception e) {
				loading = false;
			}
		}

		Select s2 = new Select(driver.findElement(By.id("state_id")));
		List<WebElement> state = s2.getOptions();
		s2.selectByIndex(randomBroj(1, state.size()));
		boolean loading2 = true;
		if (driver.findElement(By.id("msg")).getAttribute("style").equals("display: block;")) {
			try {
				driver.findElement(By.id("msg")).getAttribute("style").equals("display: none;");
			} catch (Exception e) {
				loading2 = false;
			}
		}

		Select s3 = new Select(driver.findElement(By.id("city_id")));
		List<WebElement> city = s3.getOptions();
		s3.selectByIndex(randomBroj(1, city.size()));
		Thread.sleep(3000);
		driver.quit();

	}

	public static int randomBroj(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

}
