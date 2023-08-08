package org.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Reuse extends Keywords{
	
	public static void main(String [] args) {
		
		launch("https://www.facebook.com/");
		
		maximize();
		
		WebElement user = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		
		fill(user,"selenium");
		fill(pass,"74365788");
		click(login);
	}

	

}
