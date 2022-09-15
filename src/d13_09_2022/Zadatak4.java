package d13_09_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak (Za vezbanje)
//		Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//		Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//		Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//		1243+329=
//		21912-4=
//		12913÷4=
//		U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//		Zatim u odnosu na karakter uradite odredjenu logiku
		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
		Thread.sleep(1000);

//		String formula = "256-10=";
		System.out.print("Unesite formulu: ");
		String formula = s.next();
		List<Character> chars = convertStringToCharList(formula);
		for (int i = 0; i < chars.size(); i++) {
			driver.findElement(By.xpath("//*[@value='" + chars.get(i) + "']")).click();

		}
//		Ako ne zelimo da stavimo znak = u string onda ovako on sam klikce uvek na kraju samo
//		unesemo formulu 
		driver.findElement(By.name("calculate")).click();
		Thread.sleep(5000);
		driver.quit();

	}

	public static List<Character> convertStringToCharList(String str) {
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			if (ch == '-') {
				ch = '−';
			}
			if (ch == '*') {
				ch = '×';
			}
			if (ch == '/') {
				ch = '÷';
			}
			chars.add(ch);
		}
		return chars;
	}

}
