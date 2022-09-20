package p16_09_2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HtmlTable {
	private WebElement table;

	public HtmlTable(WebElement table) {
		super();
		this.table = table;
	}

	public String getCellText(int row, int cells) {
		return table.findElement(By.xpath("//*[@class='sortable']/tbody/tr[" + row + "]/td[" + cells + "]")).getText();
	}

	public List<WebElement> getColumnsByName(String naslov) {
		List<WebElement> title = new ArrayList<>();
		
		
		return title;

	}

	public void sortDescending(String nazivKolone) {

	}

	public void sortAscending(String nazivKolone) {

	}

}
