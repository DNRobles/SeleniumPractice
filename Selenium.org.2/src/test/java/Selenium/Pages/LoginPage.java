package Selenium.Pages;

import org.testng.annotations.Test;

import pagesDemo.CheckLeave;
import pagesDemo.Credentials;
import pagesDemo.Leave;
import pagesDemo.Recruitment;
import pagesDemo.base;
import reports.selenium.Utility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ExcelReader.Reader;
import operations.ReadObject;
import operations.UI;



public class LoginPage extends base {
	String actualResult ="";
	String expectedResult = "";
	 ExtentReports extent;
	 ExtentTest logger;
	 static ExtentTest test;
	 static ExtentReports report;
	
	Credentials credentials = new Credentials();
	Leave leave = new Leave();
	CheckLeave check = new CheckLeave();
	Utility utility = new Utility();
	Recruitment recruit = new Recruitment();
	
	

	
  @Test
  public void f() throws InterruptedException {
	  
	  credentials.Credentials(driver);
	  By result = By.id("menu_leave_viewLeaveModule");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(result));	
		
		assertTrue(driver.findElement(result).isDisplayed(), "There is an error in the credentials");
		
		leave.Leave(driver);
		
		check.CheckLeave(driver);
		
		/*recruit.Recruitment(driver);*/

	  
  }

  @BeforeClass
  public void beforeClass() throws Exception {
	  
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\DemoExtentReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  logger=extent.createTest("LoginTest");
	  
	  
	    
	 /* report = new ExtentReports();
	  test = report.startTest("ExtentDemo");*/
	  
	 
		  String URL1 ="https://opensource-demo.orangehrmlive.com/index.php/leave/assignLeave";
		  launch(URL1);
		  expectedResult = "OrangeHRM";
			 actualResult = driver.getTitle();
			 Assert.assertEquals(expectedResult,actualResult );
		  
	  
  }

  @AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=Utility.getScreenshot(driver);
			
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			
			logger.pass(actualResult) ;       }
        else {
   
            test.skip(result.getThrowable());
        }
		
		driver.quit();
		
	}
  @AfterClass	
  public static void endTest()
  {
  /*report.endTest(test);
  report.flush();*/
  
  }
  
  @BeforeTest
  public void beforeTest()  {

  }

  @AfterTest
  public void afterTest() {
	  
	  
	  
	  /*driver.quit();*/
  }

}
