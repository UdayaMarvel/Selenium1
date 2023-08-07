package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.netty.channel.MessageSizeEstimator.Handle;

public class Reusabl2 {
	static WebDriver dvr;
	public static void launch (String url) {
	    dvr = new ChromeDriver();
		dvr.navigate().to("https://www.facebook.com/");
		dvr.get(url);
	}
	
	public static void maximize () {
		dvr.manage().window().maximize();
	}
	
	public static void fill (WebElement e,String value) {
	e.sendKeys(value);
	}
	public static void click (WebElement e) {
		e.click();
	}
	
	public static void quit () {
	dvr.quit();
	}
	
	public static void close () {
		dvr.close();
	}
	
}
