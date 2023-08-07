package org.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		// Type casting
		// Up casting (parent to child)
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		WebElement mail = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
//		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		WebElement scrolldown = driver.findElement(By.xpath("//a[text()='Careers']"));

		// Down casting (child to parent)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		js.executeScript("arguments[0].setAttribute('value','ds.daniel@gmail.com')", mail);
		Object execute = js.executeScript("return arguments[0].getAttribute('value')", mail);
		System.out.println(execute);
		js.executeScript("arguments[0].setAttribute('value','daniel')", pass);
//		js.executeScript("arguments[0].click()", login);
//		
//	try {
//		Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//			driver.navigate().back();
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		try {
			js.executeScript("arguments[0].scrollIntoView(true)", scrolldown);
		}catch(StaleElementReferenceException e) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(scrolldown)));
		}
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		try {
			js.executeScript("arguments[0].scrollIntoView(false)", mail);
		}catch(StaleElementReferenceException e){
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(mail)));
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background:lightblue')", mail);
		
		String st = mail.getAttribute("style");
		System.out.println(st);
		
		String back = mail.getCssValue("background");
		System.out.println(back);
		
		String size = mail.getCssValue("font-size");
		System.out.println(size);
		
		String fam = mail.getCssValue("font-family");
		System.out.println(fam);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target\\Screenshot.png");
		try {
			FileUtils.copyFile(screenshot, f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		}
		

	}


