package utils;

import org.openqa.selenium.WebDriver;

import pages.MenuPage;
import pages.MyAccountPage;

public class BasePage extends SeleniuWrappers {

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public MenuPage menu = new MenuPage(driver);
	public MyAccountPage myAccountPage = new MyAccountPage(driver);

}
