package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameClass {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		
		List<WebElement> numofframe = driver.findElements(By.tagName("iframe"));
//		System.out.println(numofframe.size());
		
		for(int i=0;i<numofframe.size();i++) {
			 driver.switchTo().frame(i);
			
				
				WebElement top = driver.findElement(By.xpath("//input[@type='text']"));
				top.sendKeys("dan");
				String success = top.getText();
				System.out.println(success);
				
				
				if(top.isDisplayed()) {
					System.out.println("successfully fetched the element: "+success);
				}else {
					System.out.println("can't able to fetched the element");
				}
				
				driver.switchTo().frame(i);
				
				WebElement cl = driver.findElement(By.xpath("//input[@id='a']"));
				cl.click();
				
				if(cl.isSelected()) {
					System.out.println("check box is selected successfully");
				}else {
					System.out.println("check box is not yet selected");
				}
				
				if(cl.isEnabled()) {
					System.out.println("check box is clicked successfully");
				}else {
					System.out.println("check box is not clicked successfully");
				}
				
				WebDriver front = driver.switchTo().parentFrame();
				System.out.println("successfully switched: "+front);
				
				WebDriver mainwindow = driver.switchTo().defaultContent();
				WebElement text = mainwindow.findElement(By.xpath("//div[@class='card mb-3']"));
				String t1 = text.getText();
				System.out.println(t1);
				break;
			
		}
		
		
		
		

//		System.out.println("successfully switched: "+mainwindow);
	}

}
