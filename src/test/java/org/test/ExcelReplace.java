package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReplace {

	
public static void main(String []args) throws Throwable{
		
		File f= new File("C:\\Users\\Admin\\Desktop\\Sugan Recruiter.xlsx");
		FileInputStream f1=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(f1);
		
		Sheet s=w.getSheet("Sugan Recruiter");
		
for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			
			s.getRow(i);
			Row r=s.getRow(i);
			
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c=r.getCell(j);
				int cellType=c.getCellType();
				if(cellType==1 ) {
					
					String value=c.getStringCellValue();
					if(value.equals("Suganya")) {
						
						c.setCellValue("Nisha");
					}
					
					//System.out.println(value);
				}
				
				else if(cellType==0) {
					
					if(DateUtil.isCellDateFormatted(c)) {
						Date d=c.getDateCellValue();
						//System.out.println(d);
						
						SimpleDateFormat sd =new SimpleDateFormat("dd/MM/yyyy");
						
						String value=sd.format(d);
						System.out.println(value);
						
					}
					else{
						double d=c.getNumericCellValue();
						long l=(long)d;
						//System.out.println(l);
						String value=String.valueOf(l);
						System.out.println(value);
						
					}
					
				}
			}
		}
		
		FileOutputStream f2=new FileOutputStream(f);
		w.write(f2);
		f2.close();
	} 


}
