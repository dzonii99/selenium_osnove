package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) {
//		Kreirati klasu HtmlTable:
//			koja od atributa ima table web element sa stranice
//			konstruktor koji prima web element sa kojim se radi
//			metodu getCellText, koja prima dva parametra row i cell od kog hocemo da procitamo tekst. Npr ako se za tabelu(2012 goald medal olympic drivers)  sa linka prozovmeo metodu sa row=1 i cell =3 metoda vraca vrednost  China
//			metodu getColumnsByName, metoda kao parametar prima naslov kolone a vraca niz elemenata, gde je svaki element celija iz trazene kolone. Npr ako se pozove metoda za �Country�, metoda vraca UnitedStates, China, China, �.Russia, �China samo ne stringove nego elemente koji cuvaju te vrednosti!
//			metodu sortDescending, koja kao parametar prima naziv kolone. Metoda treba da uradi potrebne akcije da se tabela sortira u opadajucem redosledu po trazenoj koloni. POMOC: Sortiranje je izvrseno ukoliko header trazene kolone ima klasu headerSortUp
//			metodu sortDescending, koja kao parametar prima naziv kolone. Metoda radi slicno kao za descending
//			U glavnom programu:
//			Ucitati stranicu https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/
//			Kreirati HtmlTable objekat koji se veze za 2012 Gold Medal Olympic Divers tabelu sa stranice
//			Probajte metodu getCellText
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
		WebElement table = driver.findElement(By.xpath("//table"));
		HtmlTable tabela = new HtmlTable(table);
		System.out.println(tabela.getCellText(1, 3));
		for (int i = 0; i < tabela.getColumnsByName("Age").size(); i++) {
			System.out.println(tabela.getColumnsByName("Age").get(i));
		}
		driver.quit();

	}

}
