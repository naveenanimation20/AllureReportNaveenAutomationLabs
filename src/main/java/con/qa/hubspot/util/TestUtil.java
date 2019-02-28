package con.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.hubspot.constants.Constants;

public class TestUtil {
	
	public static Workbook book;
	public static Sheet sheet;
	
	
	
	public static void shortWait(){
		try {
			Thread.sleep(Constants.SHORT_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait(){
		try {
			Thread.sleep(Constants.MEDIUM_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait(){
		try {
			Thread.sleep(Constants.LONG_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
		
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}
	
	

}
