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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationReadAndWrite {
	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");

		driver.manage().window().maximize();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.close();

		WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		search.sendKeys("redmi mobile");
		WebElement sub = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		sub.click();

		File f = new File("C:\\Users\\DANI\\Desktop\\redmi mobiles.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Redmi Mobiles");

		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
//     int rowNum = 0;
//     int count =0;
//     System.out.println(searchResults);

		for (int i = 0; i < searchResults.size(); i++) {
			WebElement mob = searchResults.get(i);
			String text = mob.getText();
			Row r = sheet.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(text);
			
			System.out.println(text);

		}
		

		FileOutputStream outputStream = new FileOutputStream(f);
		workbook.write(outputStream);
		outputStream.close();

		WebElement fourth = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));

		String text = fourth.getText();
		FileInputStream f2 = new FileInputStream(f);
		Workbook workbook1 = new XSSFWorkbook(f2);
		Sheet cs = workbook1.getSheet("Redmi Mobiles");

		for (int i = 0; i < cs.getPhysicalNumberOfRows(); i++) {
			Row r = cs.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int gst = c.getCellType();

				if (gst == 1) {
					String str = c.getStringCellValue();
					if (str.equals(text)) {
						System.out.println("PASS");
					} else {
						System.out.println("fail");
					}
				}

			}
		}

		driver.quit();

//     for (WebElement result : searchResults) {
//         String model = result.findElement(By.xpath("//div[contains(@class,'_4rR01T')]")).getText();
//         String price = result.findElement(By.xpath("//div[contains(@class,'_30jeq3 _1_WHN1')]")).getText();

//         Row row = sheet.createRow(rowNum++);
//         row.createCell(0).setCellValue(model);            
		// row.createCell(1).setCellValue(price);

//         System.out.println(model);
//         System.out.println(price);

	}

//     FileOutputStream outputStream = new FileOutputStream(f);
//      workbook.write(outputStream);
//      outputStream.close();
//     System.out.println(outputStream);

//     outputStream.close();
//

// 

}
