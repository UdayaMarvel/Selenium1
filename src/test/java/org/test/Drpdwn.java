package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drpdwn {
public static void main(String[] args) {
	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	dvr.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
	dvr.manage().window().maximize();
	WebElement single = dvr.findElement(By.xpath("//select[@id='second']"));
	Select s = new Select(single);
	boolean multi = s.isMultiple();
	System.out.println(multi);
	s.selectByIndex(1);
	s.selectByIndex(2);
	s.selectByIndex(3);
	s.deselectAll();
		
	List<WebElement> options = s.getOptions();
	for (WebElement x : options) {
		System.out.println(x.getText());
	}
	
	List<WebElement> all = s.getAllSelectedOptions();
	for (WebElement x : all) {
		System.out.println(x.getText());
	}
	
	WebElement first = s.getFirstSelectedOption();
	System.out.println(first);
	
	
	
	
	
	
}
}
