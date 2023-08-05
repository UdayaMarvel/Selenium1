package com.flipkart;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TvPurchase {
	public static WebDriver driver;
	static long startTime;
	static long endTime;
	
	@Parameters({"browser"})
	@BeforeClass
	public static void launchBrowser(String browser) {
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-popups");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);}
		else if(browser.equals("edge")){
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-popups");
		    options.addArguments("--disable-notifications");
		    options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

	
	@BeforeMethod
	public void beforeMethod() {
		startTime = System.currentTimeMillis();
//		driver.navigate().refresh();
	}
	@AfterMethod
	public void afterMethod() {
		endTime = System.currentTimeMillis();
		long timeTaken = endTime-startTime;
		System.out.println("after method"+timeTaken);
	}
	
	
@Test
public void tv1() {
	
	driver.get("https://www.flipkart.com");
}
@Test
public void tv2() {
	WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
	close.click();
	
}
@Test
public void tv3() {
	driver.findElement(By.name("q")).sendKeys("samsung Tv",Keys.ENTER);
	WebElement samsung = driver.findElement(By.xpath("//div[contains(text(),'SAMSUNG Crystal 4K Neo Series 138 cm')]"));
	String text = samsung.getText();
	boolean nn = samsung.isDisplayed();
	Assert.assertTrue(nn);
	samsung.click();	
}
	
}
