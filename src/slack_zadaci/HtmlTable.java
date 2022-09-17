package slack_zadaci;

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

}
