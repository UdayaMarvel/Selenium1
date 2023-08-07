package org.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascrptexe {
public static void main(String[] args) throws Throwable {
	
	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	
	dvr.get("https://www.facebook.com/");
	dvr.manage().window().maximize();
	Thread.sleep(2000);
	
	WebElement user =  dvr.findElement(By.xpath("//input[@type='text']"));
	WebElement pass =  dvr.findElement(By.xpath("//input[@type='password']"));
	WebElement login =  dvr.findElement(By.xpath("//button[@type='submit']"));
	WebElement down = dvr.findElement(By.xpath("//a[text()='Careers']"));
	//Javascriptexecutor 
	//Downcasting
	JavascriptExecutor js = (JavascriptExecutor)dvr;
	js.executeScript("arguments[0].setAttribute('value','selenium')", user,pass,login);
	//Object execute = js.executeScript("return arguments[0].getAttribute('value')", user);
    //System.out.println(execute);
   // js.executeScript("arguments[0].click()",login);
    //js.executeScript("arguments[0].scrollIntoView(true)",down);
    //Thread.sleep(2000);
    //js.executeScript("arguments[0].scrollIntoView(false)",user);
	js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background:yellow')",user);
	//String attribute = user.getAttribute("style");
	//System.out.println(attribute);
	//String css =  user.getCssValue("font-family");
	//System.out.println(css);
	
	TakesScreenshot tkss = (TakesScreenshot)dvr;
	File src =  tkss.getScreenshotAs(OutputType.FILE);
	File store = new File("C:\\Users\\HP\\eclipse-workspace\\NewMech\\src\\test\\resources\\login.png");
	FileUtils.copyFile(src, store);
	
	
	
	
	
	
	
}
}
