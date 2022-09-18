package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Napisati program koji ima:
//		Podesava:
//		implicitno cekanje za trazenje elemenata od 10s
//		implicitno cekanje za ucitavanje stranice od 10s
//		eksplicitno cekanje podeseno na 10s
//		Podaci:
//		Potrebno je u projektu ukljuciti 4 slike.
//		Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
//		Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
//		Koraci:
//		Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//		Maksimizuje prozor
//		Selektuje Image - Front klikom na tu karticu u dnu ekrana
//		Klik na add photo iz levog navigacionog menia
//		Upload slike. Upload preko File objekta koristeci getAbsolutePath
//		Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//		Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
//		Ceka da dijalog bude vidljiv
//		Klik na Use One Side Only dugme
//		Ceka da se pojavi dijalog sa slikom
//		Klik na Done
//		Ponoviti proces za Left, Right i Back
//		Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
//		Kliknuti na Add To Cart dugme
//		Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
//		Xpath: //*[@action='error']
//		Zatvorite pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();
		File front = new File("img/front_nikola_milovanovic.png");
		File back = new File("img/back_nikola_milovanovic.png");
		File left = new File("img/left_nikola_milovanovic.png");
		File right = new File("img/right_nikola_milovanovic.png");
		Random r = new Random();
		List<File> listaSlike = new ArrayList<File>();
		listaSlike.add(front);
		listaSlike.add(left);
		listaSlike.add(back);
		listaSlike.add(right);
		for (int i = 0; i < listaSlike.size(); i++) {
			driver.findElement(By.xpath("//*[contains(@alt, 'image " + (i + 1) + "')]")).click();
			driver.findElement(By.xpath("//*[text()='+ Add photo']")).click();
			driver.findElement(By.id("imageUpload")).sendKeys(listaSlike.get(i).getAbsolutePath());
			wait.until(
					ExpectedConditions.numberOfElementsToBe(By.xpath("//*[contains(@class, 'fqhTDx')]//img"), i + 1));
			driver.findElement(By.xpath("//*[contains(@class, 'bNhUVa')][1]//img")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Use One Side Only']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Done']"))).click();
		}
		List<WebElement> confetti = driver.findElements(By.xpath("//*[contains(@class,'sc-ewDcJz')]"));
		int x = r.nextInt(confetti.size());
		confetti.get(x).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Add to cart ']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@action='error']")));
		Thread.sleep(2000);
		System.out.println("An error occured!!!");
		driver.quit();

	}

}
