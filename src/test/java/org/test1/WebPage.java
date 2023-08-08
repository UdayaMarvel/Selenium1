package org.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPage {
	
public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	WebElement login=driver.findElement(By.xpath("//a[@role='button']"));

			login.click();
			
}

}