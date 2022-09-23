package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HeadPageTests extends AutomationPracticeTests {

	@Test(priority = 20)
	public void topMenuMouseOver() throws InterruptedException {
		new Actions(driver).moveToElement(topMenuPage.getWomenLink()).perform();
		softAssert.assertTrue(topMenuPage.getWomenMenu().isDisplayed(), "Women submenu should be visible");

		new Actions(driver).moveToElement(topMenuPage.getDressesLink()).perform();
		softAssert.assertTrue(topMenuPage.getDressesMenu().isDisplayed(), "Dresses submenu should be visible");

		new Actions(driver).moveToElement(topMenuPage.getTshirtsLink()).perform();
		softAssert.assertFalse(topMenuPage.getDressesMenu().isDisplayed() && topMenuPage.getWomenMenu().isDisplayed(),
				"Both submenus should not be visible");
		softAssert.assertAll();
	}

	@Test(priority = 30)
	public void phoneNumberVisibilityCheckOnResize() throws InterruptedException {
		driver.manage().window().maximize();
		softAssert.assertTrue(headerPage.getShopPhoneElement().isDisplayed(), "Contact us number should be visible");
		driver.manage().window().setSize(new Dimension(783, 700));
		softAssert.assertFalse(headerPage.getShopPhoneElement().isDisplayed(),
				"Contact us number should not be visible");
//		nije mi jasno sto nije htelo sa 767 i 768 a kad povecavam i smanjujem pise mi ta velicina
		driver.manage().window().setSize(new Dimension(784, 700));
		softAssert.assertTrue(headerPage.getShopPhoneElement().isDisplayed(), "Contact us number should be visible");
		softAssert.assertAll();

		driver.manage().window().maximize();
	}

	@Test(priority = 40)
	public void headerLinksCheck() {
		headerPage.getContactUsLink().click();
		softAssert.assertEquals(driver.getTitle(), "Contact us - My Store", "Title should be Contact us - My Store");
		headerPage.getSignInLink().click();
		softAssert.assertEquals(driver.getTitle(), "Login - My Store", "Title should be Login - My Store");
		softAssert.assertAll();
	}

}
