package CovidPage;

import frameworkclasses.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
	
	    public String clickStartCheckup() {
	        
	         String text = driver.findElement(By.xpath("//a[@href='/covid19/checkup/']")).getText();
	         return text;
	        
	    } 
	    
}
	
	

