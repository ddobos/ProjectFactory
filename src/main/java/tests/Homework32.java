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
		
		sa.assertTrue(shop.imageOne.getAttribute("href").contains("TheWickedKing1.png"));
		sa.assertTrue(shop.imageTwo.getAttribute("href").contains("TheWickedKing2.png"));
		sa.assertTrue(shop.imageThree.getAttribute("href").contains("TheWickedKing3.png"));
		sa.assertTrue(shop.imageFour.getAttribute("href").contains("TheWickedKing4.png"));
		
		sa.assertAll();
		
		
	}


}
