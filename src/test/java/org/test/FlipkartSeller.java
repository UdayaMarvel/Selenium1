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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSeller {
	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement seller = driver.findElement(By.xpath("(//div[@class='go_DOp'])[1]"));
		seller.click();

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement startsell = driver.findElement(By.xpath("(//button[@data-testid='button'])[5]"));
		startsell.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement mobnum = driver.findElement(By.xpath("(//input[@data-testid='test-input'])[1]"));
		mobnum.sendKeys("9003425610");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String entermobnum = mobnum.getAttribute("value");
		String exceptedformat = "\\d{10}";

		if (entermobnum.matches(exceptedformat)) {
			System.out.println("Valid mobile number: " + entermobnum);
		} else {
			System.out.println("Invalid mobile number: " + entermobnum);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement email = driver.findElement(By.xpath("(//input[@data-testid='test-input'])[2]"));
		email.sendKeys("adc@gmail.com");

		String enteremail = email.getAttribute("value");
		String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

		if (enteremail.matches(emailPattern)) {
			System.out.println("Valid Email Id: " + enteremail);
		} else {
			System.out.println("Invalid Email Id: " + enteremail);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement gstpin = driver.findElement(By.xpath("(//input[@data-testid='test-input'])[3]"));
		gstpin.sendKeys("12ABCDE1234F1Z5");

		String entergstpin = gstpin.getAttribute("value");
		String gstinPattern = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9]{1}[A-Z]{1}[A-Z0-9]{1}$";
		if (entergstpin.matches(gstinPattern)) {
			System.out.println("GST pin is valid: " + entergstpin);
		} else {
			System.out.println("GST pin is invalid: " + entergstpin);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		File f = new File("C:\\Users\\DANI\\Desktop\\Header List.xlsx"); 
		Workbook w1 = new XSSFWorkbook();
		Sheet sheet = w1.createSheet("Header List");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		List<WebElement> header = driver.findElements(By.xpath("//p[@class='styles__SellListHeader-sc-1a6y1nh-5 hSVYJQ']"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(header.isEmpty()) {
			System.out.println("The XPath is NOT valid or did not match any elements.");
			
		}else {
			System.out.println("The XPath is valid and matched " + header.size() + " element(s).");
		}
		
		for(int i=0;i<header.size();i++) {
			WebElement count = header.get(i);
			String text = count.getText();
			Row r =sheet.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(text);
		}
		
		FileOutputStream f1 = new FileOutputStream(f);
		w1.write(f1);
		f1.close();
		

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//	        WebElement startsell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='styles__RegisterButton-sc-1kfv72o-1 kFfmtT'])[1]")));
//	        wait.until(ExpectedConditions.elementToBeClickable(startsell)).click();

		driver.quit();

	}

}
