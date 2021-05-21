package pagesDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitment extends base {

	public void Recruitment(WebDriver driver) throws InterruptedException {
		
		
		WebElement recru = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
        recru.click();
        
        wait = new WebDriverWait(driver,7);
       
        Thread.sleep(2500);
        
        Select job = new Select(driver.findElement(By.id("candidateSearch_jobTitle")));  
        job.selectByIndex(13);
        
        WebElement candidate = driver.findElement(By.id("candidateSearch_candidateName"));  
        candidate.sendKeys("Archie Augustine");
        
        Select manager = new Select(driver.findElement(By.id("candidateSearch_hiringManager"))); 
        manager.selectByIndex(2);
        
        Select status = new Select( driver.findElement(By.id("candidateSearch_status")));
        status.selectByIndex(2);
        
        WebElement Date_app = driver.findElement(By.id("candidateSearch_fromDate"));
        Date_app.clear();
        Date_app.sendKeys("2020-10-08");
        Date_app.sendKeys(Keys.RETURN);
        
        wait = new WebDriverWait(driver,7);
        
        WebElement confirm = driver.findElement(By.id("btnSrch"));
        confirm.click();
	}

}
