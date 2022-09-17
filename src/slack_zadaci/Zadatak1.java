package slack_zadaci;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) {
//		Jedan za vezbanje
//		Kreirati klasu HtmlTable:
//		koja od atributa ima table web element sa stranice
//		konstruktor koji prima web element sa kojim se radi
//		Metodu getCellText, koja prima dva parametra row i cell od kog hocemo da procitamo tekst. Npr ako se za tabelu(2012 goald medal olympic drivers)  sa linka prozovmeo metodu sa row=1 i cell =3 metoda vraca vrednost  China
//		U glavnom programu:
//		Ucitati stranicu https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/
//		Kreirati HtmlTable objekat koji se veze za 2012 Gold Medal Olympic Divers tabelu sa stranice
//		Probajte metodu getCellText

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
		WebElement table = driver.findElement(By.className("sortable"));
		HtmlTable htmlTable = new HtmlTable(table);
		new Actions(driver).scrollToElement(driver.findElement(By.className("sortable"))).perform();
		System.out.println(htmlTable.getCellText(2, 2));
	}

}
