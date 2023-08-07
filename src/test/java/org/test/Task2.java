package org.test;

import java.util.LinkedHashMap;
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

public class Task2 {
public static void main(String[] args) throws Throwable {
	WebDriver dvr = new EdgeDriver();
	WebDriverManager.edgedriver().setup();
	
	dvr.get("https://www.flipkart.com/");
	dvr.manage().window().maximize();
	Thread.sleep(2000);
	try {
		WebElement close =  dvr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	WebElement search =  dvr.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	search.sendKeys("Redmi mobiles",Keys.ENTER);
	
	Thread.sleep(2000);
	

	List<WebElement> mobilename =  dvr.findElements(By.xpath("//div[@class='_4rR01T']"));
	for (int i = 0; i < mobilename.size(); i++) {
		WebElement w =  mobilename.get(i);
		String text1 = w.getText();
		//System.out.println(text1);
		
		List<WebElement> mobileprice =  dvr.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for (int j = i; j==i; j++) {
			WebElement price = mobileprice.get(i);
			String text2 =  price.getText();
			Map<String, String> mp = new LinkedHashMap<>();
			mp.put(text1, text2);
			Set<Entry<String, String>> entryset = mp.entrySet();
			for (Entry<String, String> entry : entryset) {
				System.out.println(entry);
			}
			//System.out.println(text2);	
		}
			//WebElement w = mobileprice.get(i);
			//String text2 =  w.getText();
			//System.out.println(text2);
		
	}
	
	//System.out.println(text2);
	
	
	
	//Map< WebElement, WebElement> mp = new LinkedHashMap<>();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
