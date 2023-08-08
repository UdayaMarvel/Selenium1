package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelwrite {
	
	
public static void main(String []args) throws Throwable{
		
		File f= new File("C:\\Users\\Admin\\Desktop\\Excelwrite.xlsx");
		
		//FileInputStream f1=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook();
		
		Sheet s=w.createSheet("ExcelWrite");
		Row r=s.createRow(0);
		
		//for(int i=0;i<5;i++) {
		Cell c=r.createCell(0);
		c.setCellValue("Suganya");

		FileOutputStream f2=new FileOutputStream(f);
		w.write(f2);
		f2.close();
		
		//}
		

}
}