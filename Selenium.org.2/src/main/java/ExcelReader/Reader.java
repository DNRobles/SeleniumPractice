package ExcelReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pagesDemo.base;

public class Reader extends base {

	 public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
		 
		    
		    File file = new File(filePath+"\\"+fileName);
		    
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook demo = null;
		    
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		  
		    if(fileExtensionName.equals(".xlsx")){

		    	demo = new XSSFWorkbook(inputStream);
		    }
		    else if(fileExtensionName.equals(".xls")){
		        
		    	demo = new HSSFWorkbook(inputStream);
		    }
		    //Read sheet inside the workbook by its name
		    Sheet demosheet = (Sheet) demo.getSheet(sheetName); 
		     return demosheet;    
		      
		    }
	 
}

