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

public class ExcelRead {

	public static void main(String[] args) throws Throwable {

		File f = new File("C:\\Users\\DANI\\Desktop\\New Microsoft Excel Writesheet.xlsx");
		FileInputStream f1 = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(f1);
//		Sheet cs = w.getSheet("Excel Writesheet");
//	Row cr = cs.createRow(0);
//	Cell cc = cr.createCell(0);
		Sheet g = w.getSheet("Excel Writesheet");
		for (int i = 0; i < g.getPhysicalNumberOfRows(); i++) {
			
						Row r = g.getRow(i);
						for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
						Cell c = r.getCell(j);
						int d = c.getCellType();
						if(d==1) {
							String sv = c.getStringCellValue();
							if(sv.equals("DANIEL")) {
								c.setCellValue("cyril");
							}
							
						}
						else if(d==0) {
							if(DateUtil.isCellDateFormatted(c)) {
								Date date = c.getDateCellValue();
								SimpleDateFormat sdf =new SimpleDateFormat("dd/mm/yyyy");
								String value = sdf.format(date);
								System.out.println(value);
							}else {
								double nc = c.getNumericCellValue();
								long l=(long) nc;					
								String v = String.valueOf(l);
								System.out.println(v);
							}
						}
						}
					}
		
		
//		for(int i=0;i<5;i++) {
//			Cell cc = cr.createCell(i);
//			cc.setCellValue("DANIEL");
//
//		}
//		
		
		FileOutputStream f2 = new FileOutputStream(f);
		w.write(f2);
		f2.close();
		
		
		
		
		
//		Sheet g = w.getSheet("Sheet1");
//		for (int i = 0; i < g.getPhysicalNumberOfRows(); i++) {
//			Row r = g.getRow(i);
		
//			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
//			Cell c = r.getCell(j);
//			int d = c.getCellType();
		//1------STRING    0----INTGER
//			if(d==1) {
//				String sv = c.getStringCellValue();
//				System.out.println(sv);
//			}
//			else if(d==0) {
//				if(DateUtil.isCellDateFormatted(c)) {
//					Date date = c.getDateCellValue();
//					SimpleDateFormat sdf =new SimpleDateFormat("dd/mm/yyyy");
//					String value = sdf.format(date);
//					System.out.println(value);
//				}else {
//					double nc = c.getNumericCellValue();
//					long l=(long) nc;					
//					String v = String.valueOf(l);
//					System.out.println(v);
//				}
//			}
//			}
//		}
	}

}
