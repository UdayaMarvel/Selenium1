package org.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusabl1 extends Reusabl2 {
public static void main(String[] args) throws Throwable {
	launch("https://www.facebook.com/");
	maximize();
	WebDriverWait wait = new WebDriverWait(dvr, Duration.ofSeconds(100));
//	WebElement user  = dvr.findElement(By.id("email"));
//	WebElement pass =  dvr.findElement(By.name("pass"));
//	WebElement login = dvr.findElement(By.xpath("//button[@value='1']"));
//	fill(user,"selenium");
//	fill(pass,"12234567");
//	click(login);
	String parent = dvr.getWindowHandle();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@role='button'])[2]")));
	WebElement createAcc = dvr.findElement(By.xpath("(//a[@role='button'])[2]"));
	click(createAcc);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']")));
	WebElement signuptxt = dvr.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']"));
	String txt1 =  signuptxt.getText();
	System.out.println(txt1);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_52lr fsm fwn fcg']")));
	WebElement quick = dvr.findElement(By.xpath("//div[@class='_52lr fsm fwn fcg']"));
	String txt2 = quick.getText();
	System.out.println(txt2);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
	WebElement frstName = dvr.findElement(By.xpath("(//input[@type='text'])[2]"));
	fill(frstName,"Thilak");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
	WebElement surName = dvr.findElement(By.xpath("(//input[@type='text'])[3]"));
	fill(surName,"Raj");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
	WebElement phNo = dvr.findElement(By.xpath("(//input[@type='text'])[4]"));
	fill(phNo,"7010696508");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password_step_input")));
	WebElement pass = dvr.findElement(By.id("password_step_input"));
	fill(pass,"!AAAbbcc123");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("day")));
	WebElement day = dvr.findElement(By.id("day"));
	Select s1 = new Select(day);
	s1.selectByIndex(10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("month")));
	WebElement month = dvr.findElement(By.id("month"));
	Select s2 = new Select(month);
	s2.selectByIndex(1);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("year")));	WebElement year = dvr.findElement(By.id("year"));
	Select s3 = new Select(year);
	s3.selectByValue("1996");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='2']")));
	WebElement gender = dvr.findElement(By.xpath("//input[@value='2']"));
	click(gender);
	WebElement learn = dvr.findElement(By.xpath("//a[text()='Learn more']"));
	click(learn);
	
	Set<String> child = dvr.getWindowHandles();
	for (String x : child) {
		dvr.switchTo().window(x);
	}
    close();
    dvr.switchTo().window(parent);
    
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Sign Up'])[1]")));        
	WebElement signup = dvr.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));
	click(signup);
	
}
}
