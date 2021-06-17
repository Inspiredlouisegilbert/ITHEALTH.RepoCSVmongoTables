package CovidPage;

import frameworkclasses.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
		//global variables
		String clickCheckupButton = "//a[@href='/covid19/checkup/']";
		
	    public String checkStartCheckup() {
	        
	         String text = driver.findElement(By.xpath(clickCheckupButton)).getText();
	         return text;   
	    } 
	    
	    //Click on Covid19 checkup button
	    public void clickStartCheckUp() {
	    
	    	driver.findElement(By.xpath(clickCheckupButton)).click();
	    }

	    
}
	
	

