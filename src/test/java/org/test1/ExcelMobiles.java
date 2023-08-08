package org.test1;

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

public class ExcelMobiles {
	
	public static void main(String [] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		driver.findElement(By.name("q")).sendKeys("Redmi mobiles",Keys.ENTER);
		
		Thread.sleep(2000);
		
		File f =new File("C:\\Users\\Admin\\Desktop\\Filpkart.xlsx");
		Workbook W = new XSSFWorkbook();
		Sheet s= W.createSheet("Sheet1");
		
		List<WebElement> MobileName=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
     for(int i=0;i<MobileName.size();i++) {
			
    	 WebElement mobile=MobileName.get(i);
    	 
    	 String text=mobile.getText();
			Row r = s.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(text);
			System.out.println(text);
			
		}
		
     FileOutputStream f1=new FileOutputStream(f);
		W.write(f1);
		f1.close();

		 WebElement mobile_Three = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	     String text = mobile_Three.getText();
	     FileInputStream f2 = new FileInputStream(f);
		    Workbook w1 = new XSSFWorkbook(f2);
		    Sheet s1 = w1.getSheet("Sheet1");
		    for (int i = 0; i < s1.getPhysicalNumberOfRows(); i++) {
				Row r = s1.getRow(i);
				for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
					Cell c = r.getCell(j);
					int cellType = c.getCellType();
					if (cellType==1) {
						String value = c.getStringCellValue();
						if (value.equals(text)) {
							//System.out.println("Pass");
							System.out.println(text);
				}
			}
		}
		
	}

}
}