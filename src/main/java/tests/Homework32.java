package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class Homework32 extends BaseTest {
	
	@Test(priority = 1)
	public void homeworkTest32() {

		MenuPage menu = new MenuPage(driver);
		menu.click(menu.searchImg);
		menu.sendKeys(menu.searchField, "king");
		
		menu.click(menu.searchResult);
		
		ShopPage shop = new ShopPage(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(shop.categoryElement.getText().contains("New releases"));
		sa.assertTrue(shop.productElement.getText().contains("1709"));
		
		sa.assertNotNull(shop.imageOne);
		sa.assertNotNull(shop.imageTwo);
		sa.assertNotNull(shop.imageThree);
		sa.assertNotNull(shop.imageFour);
		
		sa.assertAll();
		
		
	}


}
