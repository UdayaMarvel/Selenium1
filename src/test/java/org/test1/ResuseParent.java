package org.test1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResuseParent extends Resusechild{
	
	
public static void main(String [] args) {
		
		launch("https://www.facebook.com/");
		
		maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		
		String prnt=driver.getWindowHandle();
		
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@role='button'])[2]")));
		  
		  WebElement createAcc = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
		  click(createAcc);
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']")));
		  WebElement signuptxt = driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']"));
		  String txt1 =  signuptxt.getText();
		  System.out.println(txt1);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_52lr fsm fwn fcg']")));
		  WebElement quick = driver.findElement(By.xpath("//div[@class='_52lr fsm fwn fcg']"));
		  String txt2 = quick.getText();
		  System.out.println(txt2);
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
		  WebElement frstName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		  fill(frstName,"Thilak");
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
		  WebElement surName = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		  fill(surName,"Raj");
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
		  WebElement phNo = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		  fill(phNo,"7010696508");
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password_step_input")));
		  WebElement pass = driver.findElement(By.id("password_step_input"));
		  fill(pass,"!AAAbbcc123");
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("day")));
		  WebElement day = driver.findElement(By.id("day"));
		  Select s1 = new Select(day);
		  s1.selectByIndex(10);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("month")));
		  WebElement month = driver.findElement(By.id("month"));
		  Select s2 = new Select(month);
		  s2.selectByIndex(1);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("year")));
		  WebElement year = driver.findElement(By.id("year"));
		  Select s3 = new Select(year);
		  s3.selectByValue("1996");
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='2']")));
		  WebElement gender = driver.findElement(By.xpath("//input[@value='1']"));
		  click(gender);
		  WebElement learn = driver.findElement(By.xpath("//a[text()='Learn more']"));
		  click(learn);
		  
		  Set<String> child = driver.getWindowHandles();
		  for (String x : child) {
			  driver.switchTo().window(x);
		  }
		  close();
		    driver.switchTo().window(prnt);
		    
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Sign Up'])[1]")));        
		  WebElement signup = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));
		  click(signup);
		
}


}