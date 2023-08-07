package org.test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
public class AutomationLocators {
	public  static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driverlc = new ChromeDriver();
		driverlc.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%3F&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		driverlc.manage().window().maximize();
		WebElement email = driverlc.findElement(By.id("ap_email"));
		email.sendKeys("d.danielmariangmail.com");
		WebElement con = driverlc.findElement(By.id("continue"));
		con.click();
		WebElement cas = driverlc.findElement(By.id("createAccountSubmit"));
		cas.click();
		WebElement customer = driverlc.findElement(By.id("ap_customer_name"));
		customer.sendKeys("dan");
		WebElement mob = driverlc.findElement(By.id("ap_email"));
		mob.sendKeys("900414688");
		WebElement pass = driverlc.findElement(By.id("ap_password"));
		pass.sendKeys("900414688");
		WebElement repass = driverlc.findElement(By.id("ap_password_check"));
		repass.sendKeys("9004146883");
		WebElement verify = driverlc.findElement(By.id("continue"));
		verify.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		driverlc.navigate().forward();
		
		driverlc.switchTo().newWindow(WindowType.TAB);
		driverlc.navigate().refresh();
		driverlc.navigate().to("https://www.facebook.com/login/");
	}

}
