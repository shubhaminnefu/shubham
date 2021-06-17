package com.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProvider {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH="D:\\Eclipse\\Innefu_Crpf\\src\\main\\java\\com\\sheet\\Testdata.xlsx";
	public static Object[][] GetTestData(String sheetName){
		FileInputStream file=null;
		try {
			file=new FileInputStream((TESTDATA_SHEET_PATH));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum()+"---------"+sheet.getRow(0).getLastCellNum());
		
		for (int i = 0; i <sheet.getLastRowNum(); i++) {
			for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		
		return data;
		
	}

}
