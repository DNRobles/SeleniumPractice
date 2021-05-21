package operations;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pagesDemo.base;

public class UI extends base {

	WebDriver driver;
    public UI(WebDriver driver){
        this.driver = driver;
    }
    public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
        System.out.println("");
        switch (operation.toUpperCase()) {
        case "CLICK":
            //Perform click
            driver.findElement(this.getObject(p,objectName,objectType)).click();
            break;
        case "SETUSER":
            //Set user
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
            break;
        case "SETPASS":
            //Set password
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
            break;
        case "SETTEXT":
            //Set text
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
            break;          
        case "GOTOURL":
            //Get url of application
            driver.get(p.getProperty(value));
            break;
        case "GETTEXT":
            //Get text of an element
            driver.findElement(this.getObject(p,objectName,objectType)).getText();
            break;
        case "WAIT":
            //APPLY A WAIT
            String x =value;
            float y= Float.valueOf(x);
            long z =(long)y;
            Thread.sleep(1);
            System.out.println("Waiting");
            break;
            
        case "EXPLICITWAIT":
        	WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.getObject (p, objectName, objectType)));
        default:
            break;
        }
    }
    
    
    private By getObject(Properties p,String objectName,String objectType) throws Exception{
        //Find by xpath
        if(objectType.equalsIgnoreCase("XPATH")){
            
            return By.xpath(p.getProperty(objectName));
        }
        //find by class
        else if(objectType.equalsIgnoreCase("CLASSNAME")){
            
            return By.className(p.getProperty(objectName));
            
        }
        //ID
        else if(objectType.equalsIgnoreCase("ID")){
            
            return By.id(p.getProperty(objectName));
            
        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){
            
            return By.name(p.getProperty(objectName));
            
        }
        //Find by css
        else if(objectType.equalsIgnoreCase("CSS")){
            
            return By.cssSelector(p.getProperty(objectName));
            
        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINK")){
            
            return By.linkText(p.getProperty(objectName));
            
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
            
            return By.partialLinkText(p.getProperty(objectName));
            
        }else
        {
            throw new Exception("Wrong object type");
        }
    }

}
