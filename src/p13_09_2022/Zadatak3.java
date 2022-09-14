package p13_09_2022;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) {
//		Zadatak
//		Napisati program koji ima:
//		Niz stranica (niz stringova) koje treba da ucita. Niz je:
//		https://google.com/
//		https://youtube.com/
//		https://www.ebay.com/
//		https://www.kupujemprodajem.com/
//		Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili navigate i od svake stranice na ekranu ispisuje naslov stranice. Kako od stranice procitati naslov imate na ovom linku
//		U prevodu u konzoli treba da se ispisu:
//		Google
//		YouTube
//		Electronics, Cars, Fashion, Collectibles & More | eBay
//		KupujemProdajem
//		Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ArrayList<String> niz = new ArrayList<String>();
		driver.get("https://google.com/");
		niz.add(driver.getTitle());
		driver.get("https://youtube.com/");
		niz.add(driver.getTitle());
		driver.get("https://www.ebay.com/");
		niz.add(driver.getTitle());
		driver.get("https://www.kupujemprodajem.com/");
		niz.add(driver.getTitle());
		for (int i = 0; i < niz.size(); i++) {
			System.out.println(niz.get(i));
		}
		driver.quit();

	}

}
