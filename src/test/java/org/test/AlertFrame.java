package org.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrame {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");

		driver.manage().window().maximize();

	
		// SIMPLE ALERT
		WebElement simpleAlert = driver.findElement(By.id("alertButton"));
		simpleAlert.click();

		Alert a = driver.switchTo().alert();
		String text = a.getText();
		System.out.println(text);
		a.accept();
		
		//DELAY
		WebElement delayalert = driver.findElement(By.id("timerAlertButton"));
		delayalert.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
//		Alert a1 = driver.switchTo().alert();
		String text1 = a.getText();
		System.out.println(text1);
		a.accept();
		
		//CONFRIM ALERT
		WebElement confrimalert = driver.findElement(By.id("confirmButton"));
		confrimalert.click();
		
		String text3 = a.getText();
		System.out.println(text3);
		a.dismiss();
		
		//PROMPT ALERT
		WebElement promptalert = driver.findElement(By.id("promtButton"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		promptalert.click();
		
		a.sendKeys("dan");
		String text4 = a.getText();
		System.out.println(text4);
		a.accept();
		
		

	}

}
