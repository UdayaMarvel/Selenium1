package org.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resusechild {
	static WebDriver driver;
	  public static void launch (String url) {
		  driver = new ChromeDriver();
		  driver.navigate().to("https://www.facebook.com/");
		  driver.get(url);
	  }
	  
	  public static void maximize () {
		  driver.manage().window().maximize();
	  }
	  
	  public static void fill (WebElement e,String value) {
	  e.sendKeys(value);
	  }
	  public static void click (WebElement e) {
	    e.click();
	  }
	  
	  public static void quit () {
		  driver.quit();

}
	  
	  public static void close () {
		  driver.close();
		  }
	  
}
		  