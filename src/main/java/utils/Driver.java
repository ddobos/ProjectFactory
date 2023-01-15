package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) throws MalformedURLException {
		
		RemoteWebDriver rwd;
		
		if(browser.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver.set(new ChromeDriver());
			ChromeOptions chromeOption = new ChromeOptions();
//			chromeOption.addArguments("--headless");
			chromeOption.addArguments("--window-size=1920,1080");
			rwd = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOption);
			driver.set(rwd);
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver.get();
		}else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver.set(new FirefoxDriver());
			
			FirefoxBinary firefoxBynari = new FirefoxBinary();
//			firefoxBynari.addCommandLineOptions("--headless");
			firefoxBynari.addCommandLineOptions("--window-size=1920,1080");
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setBinary(firefoxBynari);
			rwd = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOption);
			driver.set(rwd);
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			return driver.get();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver.get();
		}
		return driver.get();
	}
}
