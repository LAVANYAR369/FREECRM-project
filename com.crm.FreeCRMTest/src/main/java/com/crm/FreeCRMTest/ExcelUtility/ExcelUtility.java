package com.crm.FreeCRMTest.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rowno,int Columno) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./TestData/FreecrmTestScriptData.xlsx");
		Workbook WB=WorkbookFactory.create(fis);
		String data=WB.getSheet(sheetname).getRow(rowno).getCell(Columno).getStringCellValue();
		WB.close();
		return data;
	}
	public int getLastRowCount(String sheetname) throws Throwable, IOException
	{
		FileInputStream fis1=new FileInputStream("./TestData/FreecrmTestScriptData.xlsx");
		Workbook wb1=WorkbookFactory.create(fis1);
		int rowcount=wb1.getSheet(sheetname).getLastRowNum();
		return rowcount;
	
	}
	public void setDataIntoExcel(String sheetname,int rowno,int columno) throws Throwable
	{
		FileInputStream fis2=new FileInputStream("./TestData/FreecrmTestScriptData.xlsx");
		Workbook wb2=WorkbookFactory.create(fis2);
		wb2.getSheet(sheetname).getRow(rowno).getCell(columno).setCellValue(sheetname);
		FileOutputStream fos=new FileOutputStream("./TestData/FreecrmTestScriptData.xlsx");
		wb2.close();
	}
}
