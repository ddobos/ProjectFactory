package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniuWrappers;

public class MyAccountPage extends SeleniuWrappers {
	
//	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement usernameField;
	@FindBy(id="password")
	public WebElement passwordField;
	@FindBy(css = "button[name='login']")
	public WebElement loginButton;
	@FindBy(css = "ul[class*='error'] strong")
	public WebElement loginErrorMsg;
	@FindBy(css = "div[class='woocommerce-MyAccount-content'] strong")
	public WebElement userNameGreetings;
	@FindBy(linkText = "Log out")
	public WebElement logoutButton;
	
	public void LoginInUp(String userName, String password) {
		sendKeys(usernameField, userName);
		sendKeys(passwordField, password);
		click(loginButton);
	}
	
	public boolean loginMsgIsDisplay(WebElement element) {
		return element.isDisplayed();
	}

}
