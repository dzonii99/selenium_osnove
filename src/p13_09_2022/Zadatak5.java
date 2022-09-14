package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Napisti program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//		Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku 
//		Ceka 1s
//		Hvata sve elemente prvog reda i stampa tekst svakog elementa 
//		Ceka 5s
//		Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/z80en");

		List<WebElement> table = driver
				.findElements(By.xpath("//*[@id='lorem']//*[@class='table table-bordered']/tbody/tr[1]/td"));
		for (int i = 0; i < table.size(); i++) {
			System.out.print(table.get(i).getText() + " \t ");
			Thread.sleep(1000);
		}
		System.out.println();
		table = driver.findElements(By.xpath("//*[@id='lorem']//*[@class='table table-bordered']/tbody/tr/td[1]"));
		for (int j = 0; j < table.size(); j++) {
			System.out.println(table.get(j).getText());
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
