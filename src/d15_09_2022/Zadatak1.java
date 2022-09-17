package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		List<WebElement> lista = driver.findElements(By.className("alert-dismissable"));

//		odozdo!!

//		for (int i = lista.size() - 1; i >= 0; i--) {
//			lista.get(i).findElement(By.className("close")).click();
//			Thread.sleep(2000);
//			boolean obrisan = true;
//			try {
//				lista.get(i).findElement(By.className("alert-dismissable"));
//			} catch (Exception e) {
//				obrisan = false;
//			}
//			if (obrisan) {
//				System.out.println("Red nije obrisan");
//			} else {
//				System.out.println("Red je obrisan");
//			}
//		}
//		driver.quit();

//		odozgo
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).findElement(By.className("close")).click();
			Thread.sleep(2000);
			boolean obrisan = true;
			try {
				lista.get(i).findElement(By.className("alert-dismissable"));
			} catch (Exception e) {
				obrisan = false;
			}
			if (obrisan) {
				System.out.println("Red nije obrisan");
			} else {
				System.out.println("Red je obrisan");
			}
		}
		driver.quit();

	}

}
