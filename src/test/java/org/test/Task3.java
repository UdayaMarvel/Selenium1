package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {
public static void main(String[] args) throws Throwable {
	WebDriver dvr = new EdgeDriver();
	WebDriverManager.edgedriver().setup();
	
	dvr.get("https://www.flipkart.com/");
	dvr.manage().window().maximize();
	Thread.sleep(2000);
	
	WebElement close =  dvr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	close.click();
	
	WebElement seller =  dvr.findElement(By.xpath("//a[@class='_3-PJz-']"));
	seller.click();
	Thread.sleep(2000);
	
	WebElement startSell =  dvr.findElement(By.xpath("(//span[contains(text(),'Start Selling')])[1]"));
	Thread.sleep(2000);
	startSell.click();
	
	
	
	
	
	
}
}
