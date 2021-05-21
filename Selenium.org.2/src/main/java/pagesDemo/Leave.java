package pagesDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leave extends base {
	
	String Name_L = "Paul Collings";
	String F_Date ="2021-08-13";
	String T_Date ="2021-08-13";
	String commnet = "Just for medical reasons";

	public void Leave(WebDriver driver) {
		
		
		WebElement assign = driver.findElement(By.id("menu_leave_assignLeave"));
		
		WebElement leave_name = driver.findElement(By.id("assignleave_txtEmployee_empName"));
		leave_name.sendKeys(Name_L);
		
		Select L_Type = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));
		L_Type.selectByIndex(5);
		
		WebElement FromDate = driver.findElement(By.id("assignleave_txtFromDate"));
		FromDate.clear();
		FromDate.sendKeys(F_Date);
		FromDate.sendKeys(Keys.RETURN);
		
		WebElement ToDate = driver.findElement(By.id("assignleave_txtToDate"));
		ToDate.clear();
		ToDate.sendKeys(T_Date);
		ToDate.sendKeys(Keys.RETURN);
		
		
		WebElement comments = driver.findElement(By.id("assignleave_txtComment"));
		comments.sendKeys(commnet);
		
		WebElement submit  =driver.findElement(By.id("assignBtn"));
		submit.click();
		
		
	}

}
