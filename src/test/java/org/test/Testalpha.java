package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testalpha {
	
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//WebElement user = driver.findElement(By.id("email"));
		
		//user.sendKeys("suganya");
		
		//user.clear();
		//user.sendKeys("Java");
		
		//String attribute =user.getAttribute("value");
		
		//if(attribute.equals("java")) {
			
		//	System.out.println("User Accepting Alphabets in respective field:"+attribute);
			
		//}
		
		//WebElement pass=driver.findElement(By.name("pass"));
		//pass.sendKeys("suganya");
		
		//WebElement login=driver.findElement(By.linkText("Create new account"));
		//WebElement login=driver.findElement(By.partialLinkText("Create new"));
		WebElement login=driver.findElement(By.linkText("Log in"));
		String text=login.getText();
		System.out.println(text);
		
		login.click();
		
		
	}

}
