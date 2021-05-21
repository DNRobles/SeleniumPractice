package pagesDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckLeave extends base {

	public void CheckLeave(WebDriver driver) {
		
		String date ="2021-08-13";
		
		WebElement leave = driver.findElement(By.id("menu_leave_viewLeaveModule"));
		leave.click();
		
		wait = new WebDriverWait((WebDriver)driver,7);	
		
		WebElement CalDate = driver.findElement(By.id("calFromDate"));
		CalDate.clear();
		CalDate.sendKeys(date);
		CalDate.sendKeys(Keys.RETURN);
		
		WebElement CalToDate = driver.findElement(By.id("calToDate"));
		CalToDate.clear();
		CalToDate.sendKeys(date);
		CalToDate.sendKeys(Keys.RETURN);
		
		WebElement status_pending = driver.findElement(By.id("leaveList_chkSearchFilter_1"));
		status_pending.click();
		
		
		WebElement search = driver.findElement(By.id("btnSearch"));
		search.click();
		
		
	}
	
}