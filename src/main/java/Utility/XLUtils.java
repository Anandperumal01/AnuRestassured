package Utility;

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
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile); // loading the particular file
		wb=new XSSFWorkbook(fi);   // workbook
		ws=wb.getSheet(xlsheet);    // sheet
		int rowcount=ws.getLastRowNum();  // in work sheet it will go and bring last used data
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	
	public static int getcolCount(String xlfile,String xlsheet,int rownum) throws IOException {
		fi=new FileInputStream(xlfile); // loading the particular file
		wb=new XSSFWorkbook(fi);   // workbook
		ws=wb.getSheet(xlsheet);    // sheet
		row=ws.getRow(rownum);   // set row
		int colcount=row.getLastCellNum();// in this row how many columns are used 
		wb.close();
		fi.close();
		return colcount;
		
	}
	
	public static String getcellvalue(String xlfile,String xlsheet,int rownum, int colnum) throws IOException {
		fi=new FileInputStream(xlfile); // loading the particular file
		wb=new XSSFWorkbook(fi);   // workbook
		ws=wb.getSheet(xlsheet);    // sheet
		row=ws.getRow(rownum);   // set row
		cell=row.getCell(colnum); 
		//int colcount=row.getLastCellNum();// in this row how many columns are used 
		String data;
		try {
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
		
		}catch(Exception e) {
			data="";
		}
		
		
		wb.close();
		fi.close();
		return data;
		
	}
	
	

}
