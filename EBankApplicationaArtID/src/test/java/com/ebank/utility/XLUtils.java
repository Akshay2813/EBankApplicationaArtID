package com.ebank.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException
	{
		
		fi= new FileInputStream(xlFile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		
		int rowCount=ws.getLastRowNum();
		wb.close();
		fi.close();
		
		return rowCount;		
	}
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException
	{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		
		row=ws.getRow(rowNum);
		int columnCount = row.getLastCellNum();
		
		wb.close();
		fi.close();
		return columnCount;	
	}
	
	public static String getcellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException
	{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		
		String data;
		try
		{
			DataFormatter formatter  = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
			System.out.print(e.getMessage());
		}
				return data;
	}
	
	public static void setcellData(String xlFile, String xlSheet,int rowNum, int colNum, String data) throws IOException
	{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		
		cell.setCellValue(data);
		
		fo=new FileOutputStream(xlFile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	

}
