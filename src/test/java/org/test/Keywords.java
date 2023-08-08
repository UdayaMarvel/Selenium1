package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	
	static WebDriver driver;
	
	public static void launch(String Url) {
		
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		
		driver.get(Url);
	}
		public static void maximize() {
			driver.manage().window().maximize();
		}
		
		public static void fill(WebElement e,String value) {
			e.sendKeys(value);	
			
		}
		
   public static void click(WebElement e) {
			
			e.click();	
		
	}

public static void quit(WebElement e) {
	
	driver.quit();	

}

}
