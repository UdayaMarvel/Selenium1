package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadsug {
	
	public static void main(String [] args) throws Throwable {
		
		File f=new File("C:\\Users\\Admin\\Desktop\\HR Suganya Recruiter.xlsx");
		FileInputStream f1=new FileInputStream(f);
		Workbook w = new XSSFWorkbook(f1);
		
		Sheet s =w.getSheet("Sheet1");
		
		for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			Row r=s.getRow(i);
			
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				
				Cell c=r.getCell(j);
				int cellType = c.getCellType();
				
				//1--string 0--nubmer &date
				
				if(cellType==1) {
					String value = c.getStringCellValue();
					
					System.out.println(value);
				}
				else if(cellType==0) {
					if(DateUtil.isCellDateFormatted(c)) {
						Date d = c.getDateCellValue();
						SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
						String value = sd.format(d);
						System.out.println(value);
					}
					
					else {
						double d=c.getNumericCellValue();
						long l=(long)d;
						
						System.out.println(l);
					}
				
			}}
			
		}
		
	}

}
