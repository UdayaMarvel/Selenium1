package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wbtbl {
public static void main(String[] args) {
	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	dvr.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
	dvr.manage().window().maximize();
	
	List<WebElement>  itable =  dvr.findElements(By.tagName("table"));
	for (int i = 0; i < itable.size(); i++) {
		WebElement tbl = itable.get(i);
		WebElement tbody = tbl.findElement(By.tagName("tbody"));
		List<WebElement> irow = tbody.findElements(By.tagName("tr"));
		for (int j = irow.size()-2; j < irow.size(); j++) {
			//WebElement row = irow.get(j);
			
			List<WebElement> idata = irow.get(j).findElements(By.tagName("td"));
			 int size = idata.size()-3;
			WebElement column = idata.get(size);
			String text = column.getText();
			System.out.println(text);
				//WebElement data =  idata.get(k);
				
				
				//if (text.equals("UAE")) {
					
				//}
			
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
