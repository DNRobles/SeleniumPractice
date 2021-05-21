package pagesDemo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelReader.Reader;
import operations.ReadObject;
import operations.UI;

public class base {

	 protected WebDriver driver;
	 protected WebDriverWait wait;
	 
	 
	 
	 public void launch(String URL) throws Exception  {
		 
			System.setProperty("webdriver.chrome.driver","src//main//resources//drivers//chromedriver.exe");	 
				driver = new ChromeDriver();
				
				
			 driver.get(URL);	 
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver,7);	
			
/*From this to below its failing, I can make it work because it says that Properties doesnt exist*/
				
				Reader file = new Reader();

				ReadObject object = new ReadObject();
				Properties allObjects = object.getObjectRepository();
				UI operation = new UI(driver);

				
				 Sheet demosheet =  (Sheet) file.readExcel(System.getProperty("user.dir")+"\\","keywords.ods.xlsx" , "KeywordFramework");
			      
			    	int rowCount = demosheet.getLastRowNum()-demosheet.getFirstRowNum();
			    	
			    	for (int i = 1; i < rowCount+1; i++) {
			    		
			    		Row row = demosheet.getRow(i);
			    		
			    		if(row.getCell(0).toString().length()==0){
			    		
			    			System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
			    			row.getCell(3).toString()+"----"+ row.getCell(4).toString());
			    		
			    			operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
			    				row.getCell(3).toString(), row.getCell(4).toString());
			    	    }
			    		else{
			    			
			    				System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
			    			}
			    		}
				 
				 
			 }

}
