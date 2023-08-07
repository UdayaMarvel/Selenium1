package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDemo2UsingFF {
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 =  new EdgeDriver();
		driver1.get("https://affiliate.flipkart.com/login");
		
	driver1.manage().window().maximize();
//		driver1.navigate().refresh();
//		driver1.navigate().to("https://www.flipkart.com/");
//		driver1.switchTo().window("https://www.flipkart.com/");
//		driver1.switchTo().parentFrame().quit();
//		driver1.switchTo().newWindow(WindowType.);
		
		WebElement user = driver1.findElement(By.id("inputEmail"));
		user.sendKeys("ds.danielmarian@gmail.com");
		user.clear();
		user.sendKeys("derickmarian2001@gmail.com");
		
		WebElement pass = driver1.findElement(By.id("inputPassword"));
		pass.sendKeys("dani1234");
		
		String at = user.getAttribute("value");
		if(at.equals("derickmarian2001@gmail.com")) {
			System.out.print("DANIEL");
		}
		
		WebElement cl = driver1.findElement(By.id("submitLogin"));
		cl.click();
		WebElement fp = driver1.findElement(By.partialLinkText("Forgot"));
		fp.click();
		WebElement fpinputmail = driver1.findElement(By.id("forgotPasswordInputEmail"));
		fpinputmail.sendKeys("abc@gmail.com");
		WebElement sub = driver1.findElement(By.name("submit"));
		sub.click();
	}

}
