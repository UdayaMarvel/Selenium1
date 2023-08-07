package org.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationFacebook {
	public static void main(String[] args) throws Throwable  {
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
		WebDriver driver = new EdgeDriver(options);
		driver.navigate().to("https://www.facebook.com/login/");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("A.danielmariandle@gmail.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("8760956390");
		
		WebElement login = driver.findElement(By.id("loginbutton"));
		login.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		
		WebElement friends = driver.findElement(By.xpath("(//div[@class='x6s0dn4 x1q0q8m5 x1qhh985 xu3j5b3 xcfux6l x26u7qi xm0m39n x13fuv20 x972fbf x9f619 x78zum5 x1q0g3np x1iyjqo2 xs83m0k x1qughib xat24cr x11i5rnm x1mh8g0r xdj266r xeuugli x18d9i69 x1sxyh0 xurb0ha xexx8yu x1n2onr6 x1ja2u2z x1gg8mnh'])[2]"));
		friends.click();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		
		WebElement allfrnds = driver.findElement(By.xpath("(//div[@class='x78zum5 xdt5ytf xq8finb x1xmf6yo x1e56ztr x1n2onr6 xqcrz7y'])[4]"));
		allfrnds.click();
		
//		WebElement profile = driver.findElement(By.xpath("(//div[@class='x78zum5 x1n2onr6'])[1]"));
//		profile.click();
		
//		WebElement proclick = driver.findElement(By.xpath("(//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w xeuugli x150jy0e x1e558r4 xjkvuk6 x1iorvi4'])[2]"));
//
//		proclick.click();
		File f = new File("C:\\Users\\DANI\\Desktop\\friend List.xlsx");
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Friend List");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		List<WebElement> frndlist = driver.findElements(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x6prxxf xvq8zen x1s688f xzsf02u']"));
		
		if (frndlist.isEmpty()) {
            System.out.println("The XPath is NOT valid or did not match any elements.");
       } else {
            System.out.println("The XPath is valid and matched " + frndlist.size() + " element(s).");
        }
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		for(int i=0;i<frndlist.size();i++) {
			WebElement name = frndlist.get(i);
			String gt = name.getText();
			
			Row r =sheet.createRow(i);
			Cell c =r.createCell(0);
			c.setCellValue(gt);
		}
		
	
		FileOutputStream f2 = new FileOutputStream(f);
		workbook.write(f2);
		f2.close();
		driver.quit();
		
		
	}

}
