package org.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Winhandle {
public static void main(String[] args) throws Throwable {

	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	dvr.get("https://www.flipkart.com/");
	dvr.manage().window().maximize();
	
	try {
		WebElement close =  dvr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	
	
	
	WebElement search =  dvr.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	search.sendKeys("Redmi mobiles",Keys.ENTER);
	
	Thread.sleep(2000);
	String parent =  dvr.getWindowHandle();
	dvr.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
	dvr.switchTo().window(parent);
	dvr.findElement(By.xpath("(//div[@class='_4rR01T'])[2]")).click();
	dvr.switchTo().window(parent);
	dvr.findElement(By.xpath("(//div[@class='_4rR01T'])[3]")).click();
	
	dvr.switchTo().window(parent);
	Set<String> child = dvr.getWindowHandles();
	List<String> child1 = new ArrayList<>(child);
//	System.out.println(parent);
//	System.out.println(child);
	//for (String x : child) {
		//if (!parent.equals(x)) {
			dvr.switchTo().window(child1.get(1));
			String text = dvr.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
			System.out.println(text);
		//}
		
	//}
	
	
	
}
}
