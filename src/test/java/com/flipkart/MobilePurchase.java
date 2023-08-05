package com.flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MobilePurchase {
	public static WebDriver driver;
	static long startTime;
	static long endTime;
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void suite1() {
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void suite2() {
		System.out.println("after suite");
	}
	
	@DataProvider(name="product")
	public Object[][] prod(){
		return new Object[][] {{"Samsung TV"}};
	}
	
	@BeforeClass(groups= "common")
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-popups");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterClass(groups= "common")
	public static void closeBrowser() {
		driver.quit();
	}

	
	@BeforeMethod(groups= "common")
	public void beforeMethod() {
		System.out.println("before method");
		startTime = System.currentTimeMillis();
//		driver.navigate().refresh();
	}
	@AfterMethod(groups= "common")
	public void afterMethod() {
		endTime = System.currentTimeMillis();
		long timeTaken = endTime-startTime;
		System.out.println("after method"+timeTaken);
	}
	
@Test(priority= -1, groups = "smoke")
public void enter_the_Url() {
	
	driver.get("https://www.flipkart.com");
}
@Test(priority= 0, groups = "smoke")
public void close_the_login_page() throws IOException {
	File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Project_June1\\src\\test\\resources\\credentials.property");
	FileInputStream f1 = new FileInputStream(f);
	Properties p = new Properties();
	p.load(f1);
	String mailID = p.getProperty("mail");
	WebElement mail = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	mail.sendKeys(mailID);
	p.setProperty("user", "Udhayam");
	FileOutputStream f2 = new FileOutputStream(f);
	p.save(f2, "updated user name");
//	WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
//	close.click();
	
}
@Parameters({"send","send1"})
@Test(priority= 1, groups= "smoke")
public void search_for_product(@Optional("Sony Tv")String prod1, @Optional("MI Tv")String prod2) {
	
	driver.findElement(By.name("q")).sendKeys(prod1,Keys.ENTER);
	System.out.println(prod2);
	WebElement samsung = driver.findElement(By.xpath("//div[contains(text(),'SAMSUNG Crystal 4K Neo Series 138 cm')]"));
	String text = samsung.getText();
	boolean nn = samsung.isDisplayed();	
	Assert.assertTrue(false);
	samsung.click();
}

@Test(priority = 2, groups = "sanity")
public void method() {
	System.out.println("4th method");
}

}
