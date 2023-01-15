package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniuWrappers extends BaseTest {
	
//	WebDriver driver;
	
	public SeleniuWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendEnter() {
		try {
			Log.info("calling method <send Enter>");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
		}catch(Exception e) {
			Log.error(e.getMessage());
		}
	}
	
//	public WebElement getWebElement(By locator) {
//		waitForELementToBeVisible(locator);
//		return driver.findElement(locator);
//	}
	
//	public List<WebElement> getWebElements(By locator) {
//		waitForELementToBeVisible(locator);
//		return driver.findElements(locator);
//	}

	public void click(WebElement element) {
		try {
			
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(locator));
			waitForElementToBeClicable(element);
//			WebElement element = driver.findElement(locator);
			Log.info("caled method <Click()> on element : " + element.getAttribute("outerHTML"));
			element.click();
		} catch (NoSuchElementException e) {
			Log.error("Element not found on methode <Click()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}catch (StaleElementReferenceException e) {
			waitForElementToBeClicable(element);
//			WebElement element = driver.findElement(locator);
			Log.info("caled method <Click()> on element : " + element.getAttribute("outerHTML"));
			element.click();
		}
	}

	public void waitForElementToBeClicable(WebElement element) {
		try {
			Log.info("Called methos <WaitForElementToBeClicable()> on element with locator : " + element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(NoSuchElementException e) {
			Log.error("Element not found on methode <WaitForElementToBeClicable()()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForElementToBeUnclicable(By locator) {
		try {
			Log.info("Called methos <WaitForElementToBeClicable()> on element with locator : " + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(locator)));
		}catch(NoSuchElementException e) {
			Log.error("Element not found on methode <WaitForElementToBeDisappear()()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForELementToBeVisible(WebElement element) {
		try {
			Log.info("Called methos <WaitForElementToVisible()> on element with locator : " + element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e){
			Log.error("Element not found on methode <WaitForElementToBeVisible()()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public boolean checkElementIsDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void sendKeys(WebElement element, String textToBeSend) {
		try {
			
			waitForELementToBeVisible(element);
//			WebElement element = driver.findElement(locator);
			Log.info("Called clear on methode <sendKeys()> on element " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("Called sendKeys on methode <sendKeys()> on element " + element.getAttribute("outerHTML"));
			element.sendKeys(textToBeSend);
		}catch(NoSuchElementException e) {
			Log.error("Failed method <sendKeys()> with error " + e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void hoverElement(WebElement element) {
		try{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
		catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	
	public void dragAndDrop(WebElement element, int x, int y) {
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(element, x, y).perform();
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	
	public void filterByIndex(WebElement element, int index) { //42
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		
	}
	
	public void filterByValue(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	
	public String getFilterValue(By locator) {
		Select dropdown = new Select(driver.findElement(locator));
		return dropdown.getFirstSelectedOption().getText();
	}

}
