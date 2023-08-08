package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebNavisuga {
	
	public static void main(String [] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		//driver.get("https://www.facebook.com/");
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		//String pageSource=driver.getPageSource();
		//System.out.println(pageSource);
		
		//driver.quit();
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
