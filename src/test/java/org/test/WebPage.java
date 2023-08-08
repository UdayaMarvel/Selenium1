package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPage {
	
	public static void main(String []args) throws InterruptedException {
		
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\eclipse-workspace\\Julybatch\\target\\msedgedriver.exe");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.navigate().to("https://www.linkedin.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.close();
		
		//Thread.sleep(2000);
		//driver.navigate().back();
		//Thread.sleep(2000);
		//driver.navigate().forward();
		//Thread.sleep(2000);
		//driver.navigate().refresh();
		
		//String currentUrl = driver.getCurrentUrl();
		//System.out.println(currentUrl);
		
		//String title =driver.getTitle();
		//System.out.println(title);
		
		///driver.quit();
	}

}
