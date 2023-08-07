package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frms {
public static void main(String[] args) throws Throwable {
	
	
	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	
	dvr.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	dvr.manage().window().maximize();
	Thread.sleep(2000);
	List<WebElement> iframe = dvr.findElements(By.tagName("iframe"));
	int size = iframe.size();
	System.out.println(size);
	for (int i = 0; i < size; i++) {
		dvr.switchTo().frame(i);
		for (int j = 0; j < size; j++) {
			dvr.switchTo().frame(j);
			WebElement checkbox = dvr.findElement(By.xpath("//input[@id='a']"));
			checkbox.click();
			boolean enable = checkbox.isEnabled();
			System.out.println(enable);
			break;
		}
		break;
//		WebElement checkbox = dvr.findElement(By.xpath(""));
//		checkbox.click();
//		boolean select = checkbox.isSelected();
//		System.out.println(select);
		//Boolean display = dvr.findElement(By.xpath("//b[@id='topic']")).isDisplayed();
		//System.out.println(display);
	}
	
//	dvr.switchTo().frame("frame1");
//	dvr.switchTo().frame("frame3");
//	
//	dvr.findElement(By.xpath("//input[@id='a']")).click();
//	dvr.switchTo().parentFrame();
//	String text = dvr.findElement(By.xpath("//b[@id='topic']")).getText();
//	System.out.println(text);
//	dvr.switchTo().defaultContent();
//	String text2 = dvr.findElement(By.xpath("//span[text()='Not a Friendly Topic']")).getText();
//	System.out.println(text2);
	
	
	
	
	
	
	
	
	
}
}

