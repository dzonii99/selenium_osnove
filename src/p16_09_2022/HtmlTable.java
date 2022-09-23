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
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> column = headers.get(0).findElement(By.tagName("tr")).findElements(By.tagName("td"));
		List<WebElement> elements = new ArrayList<>();
		for (int i = 0; i < headers.size(); i++) {
				if (headers.get(i).equals(naslov)) {
					elements.add(column.get(i));
			}
		}
		return elements;

	}

	public void sortDescending(String nazivKolone) {

	}

	public void sortAscending(String nazivKolone) {

	}

}
