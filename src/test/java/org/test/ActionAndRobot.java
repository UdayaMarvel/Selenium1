package org.test;

//import java.awt.Robot;
//import java.awt.event.KeyEvent;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAndRobot {

	public static void main(String[] args) throws Throwable {

//		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");

//		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
//		email.sendKeys("abc@gmail.com");
//
//		Actions ac = new Actions(driver);
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		ac.doubleClick(email).build().perform();
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		ac.contextClick(email).build().perform();
//
//		Robot r = new Robot();
//
//		for (int i = 0; i < 2; i++) {
//			r.keyPress(KeyEvent.VK_DOWN);
//			r.keyRelease(KeyEvent.VK_DOWN);
//
//		}
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
//
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_V);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_V);

//		driver.manage().window().maximize();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		WebElement move = driver.findElement(By.xpath("//*[text()='Fashion']"));
//		
		Actions ac = new Actions(driver); 
//		
//		ac.moveToElement(move).perform();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		
//		WebElement toys = driver.findElement(By.xpath("//*[text()='Beauty, Toys & More']"));
//		ac.moveToElement(toys).perform();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		
//		ac.contextClick(move).perform();

//		
		WebElement drag1 = driver.findElement(By.xpath("//li[@class='block14 ui-draggable']"));
		WebElement drop1 = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		WebElement drag2 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
		WebElement drop2 = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
		WebElement drag3 = driver.findElement(By.xpath("//li[@class='block15 ui-draggable']"));
	    WebElement drop3 = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
	    WebElement drag4 = driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[2]"));
		WebElement drop4 = driver.findElement(By.xpath("(//ol[@class='field13 ui-droppable ui-sortable'])[2]"));
		

		
		ac.dragAndDrop(drag1, drop1).build().perform();
		ac.dragAndDrop(drag2, drop2).build().perform();
		ac.dragAndDrop(drag3, drop3).build().perform();
		ac.dragAndDrop(drag4, drop4).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
		
		
		WebElement per = driver.findElement(By.xpath("//a[text()='Perfect!']"));
		
		if(per.isDisplayed()) {
			System.out.println("Drag and Drop is passed");
		}else {
			System.out.println("Drag and Drop is not passed");
		}
//		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		
//		WebElement drag2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='button button-orange'])[2]")));
//		WebElement drop2 = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
		
		
		
//		
//		
//		
//		
//		WebElement drag3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='block15 ui-draggable']")));
//		WebElement drop3 = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
//		
////		//		
//		
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		
//			e.printStackTrace();
//		}
//		
		
//		

//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		
//			e.printStackTrace();
//		}

//	

	}

}
