package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testalpha2 {


	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		List<WebElement> login=driver.findElements(By.tagName("a"));
		
		for(WebElement x:login) {
			
			System.out.println(x.getText());
		}
}
}