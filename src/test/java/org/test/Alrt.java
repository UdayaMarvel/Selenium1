package org.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alrt {
public static void main(String[] args) throws Throwable {
	
	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	
	dvr.get("https://demoqa.com/alerts");
	dvr.manage().window().maximize();
	//simple alert
	dvr.findElement(By.id("alertButton")).click();
	Alert a =  dvr.switchTo().alert();
	String text = a.getText();
	System.out.println(text);
	a.accept();
	//cofirm alert
	
	dvr.findElement(By.id("confirmButton")).click();
	String text1 = a.getText();
	System.out.println(text1);
	a.dismiss();
	
	//prompt alert
	Thread.sleep(2000);
	dvr.findElement(By.xpath("(//button[text()='Click me'])[4]")).click();
	String text2 = a.getText();
	System.out.println(text2);
	a.sendKeys("thilak");
	a.accept();
	
	
	
	
	
	
	
	
	
	
	
	
}
}
