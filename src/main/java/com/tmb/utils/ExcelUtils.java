package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;
import com.tmb.exceptions.FrameworkExceptions;
import com.tmb.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {

	
	private ExcelUtils() {
		
	}
	
	public static List<Map<String,String>> getTestDetails(String sheetname){
		
		//FileInputStream fs = null;
		XSSFWorkbook wb = null;
		// try with resources
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath()) ) {
			//fs = new FileInputStream(FrameworkConstants.getExcelpath());
			wb = new XSSFWorkbook(fs);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			throw new InvalidPathForExcelException("Excel file not found");
			
		}
		catch (IOException e) {
			//e.printStackTrace();
			throw new InvalidPathForExcelException("Excel file not found");
		}
//		finally {
//			try {
//				if(Objects.nonNull(fs)) {
//					fs.close();
//				}
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		}
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		
		int lastrownum = sheet.getLastRowNum();
		int lastcolnum	 = sheet.getRow(0).getLastCellNum();
		
		Map<String,String> map = null;
		List<Map<String,String>> list = new ArrayList<>();
				 
		for (int i = 1; i <= lastrownum; i++) {
			map = new HashMap<>();
			for (int j = 0; j < lastcolnum; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				
			}
			list.add(map);
		}
		return list;
	}
	
}
