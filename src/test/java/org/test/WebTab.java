package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTab {

	
	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		EdgeOptions edge = new EdgeOptions();
		
		//edge.addArguments("headless");
		WebDriver driver=new EdgeDriver(edge);
		driver.navigate().to("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.manage().window().maximize();
		
		List<WebElement> iTable =driver.findElements(By.tagName("table"));
		
		for(int i=0;i<iTable.size();i++) {
			WebElement table=iTable.get(i);
			WebElement tBody=table.findElement(By.tagName("tbody"));
			List<WebElement> tRow=tBody.findElements(By.tagName("tr"));
			for(int j=tRow.size()/2;j<tRow.size();j++) {
				
				WebElement row=tRow.get(j);
				List<WebElement> iData=row.findElements(By.tagName("td"));
	              
				for(int k=0;k<iData.size();k++) {
					
					WebElement data=iData.get(k);
					String text =data.getText();
					
					System.out.println(text);
					break;
					//if(text.equals("UAE")) {
						//System.out.println(text);
					//}
				}
				
			}
			
			
		}
		
		
	}
}
