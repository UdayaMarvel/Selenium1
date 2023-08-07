package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
public static void main(String[] args) throws Throwable {
	WebDriver dvr = new EdgeDriver();
	WebDriverManager.edgedriver().setup();
	
	dvr.get("https://www.flipkart.com/");
	dvr.manage().window().maximize();
	Thread.sleep(2000);
	
	WebElement close =  dvr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	close.click();
	
	WebElement search =  dvr.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	search.sendKeys("Redmi mobiles",Keys.ENTER);
	
	Thread.sleep(2000);
	
	File f = new File("C:\\Users\\HP\\eclipse-workspace\\NewMech\\src\\test\\resources\\flipkart.xlsx");
	Workbook w = new XSSFWorkbook();
	Sheet s = w.createSheet("Sheet1");
	
	
	List<WebElement> mobilename =  dvr.findElements(By.xpath("//div[@class='_4rR01T']"));
	for (int i = 0; i < mobilename.size(); i++) {
		WebElement mobile = mobilename.get(i);
		String text =  mobile.getText();
		System.out.println(text);
		Row r =  s.createRow(i);
		Cell c =  r.createCell(0);
		c.setCellValue(text);
	}
	
	FileOutputStream f1 = new FileOutputStream(f);
	w.write(f1);
	f1.close();
	
	WebElement mobilethree =  dvr.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	String text = mobilethree.getText();
	
	FileInputStream f2 = new FileInputStream(f);
	Workbook w1 = new XSSFWorkbook(f2);
	Sheet s1 =  w1.getSheet("Sheet1");
	for (int i = 0; i < s1.getPhysicalNumberOfRows(); i++) {
		Row r = s1.getRow(i);
		for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			Cell c = r.getCell(j);
			int celltype = c.getCellType();
			
			if (celltype==1) {
				String cellvalue = c.getStringCellValue();
				if (cellvalue.equals(text)) {
					System.out.println("Pass");
				}
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
}

	
}
