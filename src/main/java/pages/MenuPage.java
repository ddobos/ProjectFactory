package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniuWrappers;

public class MenuPage extends SeleniuWrappers {

//	public WebDriver driver;

	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "My account")
	public WebElement myAccountLink;
	@FindBy(css = "button[class*='icon-search']")
	public WebElement searchImg;
	@FindBy(css = "input[class='search_field']")
	public WebElement searchField;
	@FindBy(linkText = "The Wicked King")
	public WebElement searchResult;
//	public By searchField = By.cssSelector("input[type='search']");
//	public By suggestionProduct = By.cssSelector("a[class*='dgwt-wcas-suggestion']");
//	public By cartLink = By.linkText("CART");
	

}
