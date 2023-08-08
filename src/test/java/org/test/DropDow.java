package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDow {
	

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver dvr = new ChromeDriver();
		
		dvr.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		dvr.manage().window().maximize();
		
		WebElement single= dvr.findElement(By.xpath("//select[@id='first']"));
		
		Select s=new Select(single);
		boolean multiple =s.isMultiple();
		System.out.println(multiple);
		
		s.selectByIndex(1);
		s.selectByIndex(2);
		s.selectByIndex(3);
		
		List<WebElement> options=s.getOptions();
		for(WebElement x: options) {
			
			System.out.println(x.getText());
			
			
		}
		
		

}
}