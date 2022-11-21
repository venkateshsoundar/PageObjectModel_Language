package com.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaddata {

	public static String[][] exceldata(String filename,String sheetname) throws IOException {
		// TODO Auto-generated method stub

		// open the file
		XSSFWorkbook excelbook = new XSSFWorkbook("./testdata/" + filename + ".xlsx");
		// naivgate to sheet
		// XSSFSheet sheet=excelbook.getSheetAt(0);
		XSSFSheet sheet = excelbook.getSheet(sheetname);

		int lastRowNum = sheet.getLastRowNum();
		System.out.println("rowcount: " + lastRowNum);

		XSSFRow row = sheet.getRow(0);
		short lastCellNum = row.getLastCellNum();
		System.out.println("colcount: " + lastCellNum);
		String[][] data = new String[lastRowNum][lastCellNum];

		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow currentrow = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell currentcell = currentrow.getCell(j);
				data[i - 1][j] = currentcell.getStringCellValue();
				System.out.println(currentcell.getStringCellValue());

			}
		}

		excelbook.close();
		return data;

	}

}
