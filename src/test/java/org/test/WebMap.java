package org.test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebMap {
	
	public static void main(String[] args) throws Throwable {
		WebDriver dvr = new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		
		dvr.get("https://www.flipkart.com/");
		dvr.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement close =  dvr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();
		
		WebElement search =  dvr.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));////"input[@class='_3704LK']"
		search.sendKeys("dell laptop",Keys.ENTER);
		
		Thread.sleep(2000);
		
		Map<String,String> mp=new HashMap<>();
		
		List<WebElement> laptopname =  dvr.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (int i = 0; i < laptopname.size(); i++) {
			WebElement laptop = laptopname.get(i);
			String text =  laptop.getText();
			
			List<WebElement> laptopprice =  dvr.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
			for (int j = 0; j==i; j++) {
				WebElement price =laptopprice.get(j);
				String text2 = price.getText();
				mp.put(text, text2);
			
				Set<Entry<String,String>> entrySet=mp.entrySet();
				for(Entry<String,String> entry:entrySet) {
					
					System.out.println(entry);
				}
			
		}
		
		}
		
	

	}}

