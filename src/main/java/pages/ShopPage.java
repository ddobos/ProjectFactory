package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniuWrappers;

public class ShopPage extends SeleniuWrappers{

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span[class='posted_in']")
	public WebElement categoryElement;
	@FindBy(css ="span[class='product_id']")
	public WebElement productElement;
	@FindBy(xpath =  "//a[@class='inited'][contains(@href,'TheWickedKing1.png')]")
	public WebElement imageOne;
	@FindBy(xpath =  "//a[@class='inited'][contains(@href,'TheWickedKing2.png')]")
	public WebElement imageTwo;
	@FindBy(xpath =  "//a[@class='inited'][contains(@href,'TheWickedKing3.png')]")
	public WebElement imageThree;
	@FindBy(xpath =  "//a[@class='inited'][contains(@href,'TheWickedKing4.png')]")
	public WebElement imageFour;
	
}
