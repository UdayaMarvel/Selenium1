package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelUrl extends Keywords{
	
	public static void main(String[] args) throws Throwable {
		launch("https://www.facebook.com/");
		maximize();
		WebElement user=driver.findElement(By.id("email"));
		WebElement pass=driver.findElement(By.id("pass"));
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));

		fill(user,"selenium");
		fill(pass,"281187");
		click(login);
		
	}

}
