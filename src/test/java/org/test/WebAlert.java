package org.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAlert {
	
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alertButton")).click();
		//simple alert
		Alert a = driver.switchTo().alert();
		String text =a.getText();
		System.out.println(text);
		a.accept();
		//Confirm Alert
		driver.findElement(By.id("confirmButton")).click();
		String text1 = a.getText();
		System.out.println(text1);
		a.dismiss();
		
		driver.findElement(By.id("promtButton")).click();
		String text12 = a.getText();
		System.out.println(text12);
		a.sendKeys("selenium");
		a.dismiss();
		

	}

}
