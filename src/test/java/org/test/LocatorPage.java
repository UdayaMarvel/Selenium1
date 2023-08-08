package org.test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorPage {
	public static void main(String []args) throws Throwable{
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
		WebElement user = driver.findElement(By.id("email"));
		user.sendKeys("suganya");
		user.clear();
		user.sendKeys("Devi");
		
		String attribute =user.getAttribute("value");
		if(attribute.equals("suganya")) {
			
			System.out.println("user accepting alphabets in respective field:" + attribute);
		}
		
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys("suganya");
		

		//WebElement login = driver.findElement(By.linkText("Log in"));
		
		//WebElement login = driver.findElement(By.partialLinkText("Log"));
		//String text=login.getText();
		//System.out.println(text);
		//login.click();
		List<WebElement> login = driver.findElements(By.tagName("a"));
           
		for(WebElement x:login) {
			System.out.println(x.getText());
			
		}
		

	}

}
