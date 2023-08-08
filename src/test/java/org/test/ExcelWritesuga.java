package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWritesuga {

	
public static void main(String []args) throws Throwable{
		
		File f= new File("C:\\Users\\Admin\\Desktop\\Sugan Recruiter.xlsx");
		
		Workbook w=new XSSFWorkbook();
		
		Sheet s=w.createSheet("Sugan Recruiter");
		
		Row r=s.createRow(0);
		
		for(int i=0;i<5;i++) {
			
			Cell c=r.createCell(i);
			c.setCellValue("Suganya");
		}
		
		FileOutputStream f2=new FileOutputStream(f);
		
		w.write(f2);
		f2.close();
}
}