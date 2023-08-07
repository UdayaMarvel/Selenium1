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

public class ExcelWrite {
	public static void main(String[] args) throws Throwable {
		File f = new File("C:\\Users\\HP\\Desktop\\ExcelWrite.xlsx");
		FileInputStream f1 = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(f1);
		Sheet s = w.getSheet("ExcelWrite");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();
				
				if (cellType==1) {
					String cellvalue = c.getStringCellValue();
					if (cellvalue.equals("Thilak")) {
						c.setCellValue("Tamil");
					}
					System.out.println(cellvalue);
				}
				else if (cellType==0) {
					if (DateUtil.isCellDateFormatted(c)) {
						Date d = c.getDateCellValue();
						SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
						String value = sd.format(d);
						System.out.println(value);
					}
					else {
						double d = c.getNumericCellValue();
						long l = (long)d;
						String valueof = String.valueOf(l);
						System.out.println(valueof);
					}
				}
				
			}
			
		}
		
		
		
		FileOutputStream f2 = new FileOutputStream(f);
		w.write(f2);
		f2.close();
	}
}
