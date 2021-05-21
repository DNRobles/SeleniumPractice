package pagesDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ExcelReader.Reader;

public class Credentials extends base {
	
	 String username = "Admin";
	 String password = "admin123";

	public void Credentials(WebDriver driver) {
		
		
			
		WebElement name = driver.findElement(By.id("txtUsername"));
		name.sendKeys(username);
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.sendKeys(password);
		
		WebElement btnsubmit = driver.findElement(By.id("btnLogin"));
        btnsubmit.click();
		
	}

}
