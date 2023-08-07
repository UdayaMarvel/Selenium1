package org.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actn {
public static void main(String[] args) throws Throwable {
	//WebDriver dvr = new EdgeDriver();
	//WebDriverManager.edgedriver().setup();
	WebDriver dvr = new ChromeDriver();
	WebDriverManager.chromedriver().setup();

	dvr.get("https://demo.guru99.com/test/drag_drop.html");
	dvr.manage().window().maximize();
	Thread.sleep(2000);
	//try {
		//WebElement close =  dvr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		//close.click();
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
	
	//WebElement search =  dvr.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	//Actions ac = new Actions(dvr);
	//ac.sendKeys(search,"Redmi mobiles",Keys.ENTER);
	
	//WebElement move =  dvr.findElement(By.xpath("(//div[@class='xtXmba'])[3]"));
	//Actions ac = new Actions(dvr);
	//ac.moveToElement(move).perform();
	//WebElement user =  dvr.findElement(By.xpath("//input[@type='text']"));
	//user.sendKeys("thilak");
	
	//Actions ac = new Actions(dvr);
	//ac.doubleClick(user).build().perform();
	//ac.contextClick(user).build().perform();
	
	//Robot r =new Robot();
	//for (int i = 0; i < 2; i++) {
		//r.keyPress(KeyEvent.VK_DOWN);
		//r.keyRelease(KeyEvent.VK_DOWN);
	//}

	
	//r.keyPress(KeyEvent.VK_ENTER);
	//r.keyRelease(KeyEvent.VK_ENTER);
	
	//r.keyPress(KeyEvent.VK_TAB);
	//r.keyRelease(KeyEvent.VK_TAB);
	
	//r.keyPress(KeyEvent.VK_CONTROL);
	//r.keyPress(KeyEvent.VK_V);
	//r.keyRelease(KeyEvent.VK_CONTROL);
	//r.keyRelease(KeyEvent.VK_V);
	WebElement drag = dvr.findElement(By.xpath("//a[contains(text(),'BANK')]"));
	WebElement drop = dvr.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
	Actions ac = new Actions(dvr);
	ac.dragAndDrop(drag, drop).build().perform();
	
	WebElement drag1 = dvr.findElement(By.xpath("//a[text()=' 5000 ']"));
	WebElement drop1 = dvr.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
	Actions ac1 = new Actions(dvr);
	ac1.dragAndDrop(drag1, drop1).build().perform();
	
	WebElement drag2 = dvr.findElement(By.xpath("//a[contains(text(),' SALES ')]"));
	WebElement drop2 = dvr.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
	Actions ac2 = new Actions(dvr);
	ac2.dragAndDrop(drag2, drop2).build().perform();
	
	WebElement drag3 = dvr.findElement(By.xpath("//a[text()=' 5000 ']"));
	WebElement drop3 = dvr.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
	Actions ac3 = new Actions(dvr);
	ac3.dragAndDrop(drag3, drop3).build().perform();
	
	
	
}
}
