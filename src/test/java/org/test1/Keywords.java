package org.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	
	static WebDriver driver;
	public static void launch (String url) {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get(url); 
		
	}
	public static void maximize() {
		
		driver.manage().window().maximize();
	}

public static void fill(WebElement e,String Value) {
	
	e.sendKeys(Value);
}
	
public static void click(WebElement e) {
	
	 e.click();
}

public static void quit() {
	
	driver.quit();
}



}
