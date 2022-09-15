package p15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
//		 .Zadatak
//		Ucitava stranicu https://demoqa.com/login
//			Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
//			Zatim ceka 5sekundi da se korisnik uloguje
//			Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout. Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
//			Klikce na dugme za logout
//			Gasi stranicu
//		programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);

//		boolean logoutExist = driver.findElements(By.id("submit")).size() > 0;
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("submit"));
		} catch (NoSuchElementException error) {
			elementPostoji = false;
		}
		if (elementPostoji) {
			System.out.println("Prijavili ste se");
		} else {
			System.out.println("Niste se prijavili");
		}
		driver.quit();

	}

}
