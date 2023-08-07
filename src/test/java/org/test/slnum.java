package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class slnum {
public static void main(String[] args) throws Throwable {
	//System.setProperty("webdriver.edge.driver","C:\\Users\\HP\\eclipse-workspace\\NewMech\\target\\msedgedriver.exe" );
	
	WebDriver dvr = new EdgeDriver();
	WebDriverManager.edgedriver().setup();
	dvr.navigate().to("https://www.facebook.com/");
	dvr.manage().window().maximize();
	WebElement user  = dvr.findElement(By.id("email"));
	
	user.sendKeys("thilak");
	
	
	String attribute = user.getAttribute("value");
	
	if (attribute.equals("thilak")) {
		System.out.println("User accepting alphabets in respective field:"+attribute);
		
	}
	
	WebElement pass =  dvr.findElement(By.name("pass"));
	
	pass.sendKeys("thilak");
	
	List<WebElement> login = dvr.findElements(By.tagName("a"));
	for (WebElement x : login) {
		System.out.println(x.getText());
	}
	//String text = login.getText();
	//System.out.println(text);
	//login.click();
	
	
	
	
	
	
	
	
	//Thread.sleep(2000);
	//dvr.navigate().back();
	//Thread.sleep(2000);
	//dvr.navigate().forward();
	//Thread.sleep(2000);
	//dvr.navigate().refresh();
	//String currenturl = dvr.getCurrentUrl();
	//System.out.println(currenturl);
	
	//String title = dvr.getTitle();
	//System.out.println(title);
	//dvr.quit();
	//dvr.switchTo().newWindow(WindowType.TAB);
	//Thread.sleep(3000);
	//dvr.close();
	
	
	
	
	
	
	
}
}
