package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends AutomationPracticeTests {

	@Test(priority = 10)
	public void addingProductToTheCart() {
		driver.get(baseUrl + "/index.php?id_product=1&controller=product");
		buyBoxPage.scrollToTheElement();

		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");

		buyBoxPage.getSizeSelect().selectByVisibleText("L");

		buyBoxPage.getColor("Blue").click();

		buyBoxPage.getAddToCartButton().click();

		layerCartPage.waitForMessageToBeVisible();

		Assert.assertEquals(layerCartPage.getQuantityNumber().getText(), "3", "Quantity should be 3");
		Assert.assertTrue(layerCartPage.getAttributesOfElements().getText().contains("L"), "Size should be L");
		Assert.assertTrue(layerCartPage.getAttributesOfElements().getText().contains("Blue"), "Color should be blue");
//		Assert.assertEquals(layerCartPage.getTotalPriceElement().getText(), "$" + 16.51 * 3);
		String ttlPrice = layerCartPage.getTotalPriceElement().getText().replace("$", "");
		double totalPrice = Double.parseDouble(ttlPrice);
		String prdctPrice = buyBoxPage.getProductPrice().getText().replace("$", "");
		double productPrice = Double.parseDouble(prdctPrice);
		Assert.assertEquals(totalPrice, productPrice * 3, "Total price should be 3 times higher then regular price");

		layerCartPage.getContinueShoppingButton().click();
		layerCartPage.waitForMessageToBeInvisible();

		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");

		buyBoxPage.getSizeSelect().selectByVisibleText("S");

		buyBoxPage.getColor("Orange").click();

		buyBoxPage.getAddToCartButton().click();

		layerCartPage.waitForMessageToBeVisible();

		layerCartPage.getProceedToCheckoutButton().click();

		Assert.assertEquals(driver.getTitle(), "Order - My Store", "Title should be Order - My Store");

	}
}
