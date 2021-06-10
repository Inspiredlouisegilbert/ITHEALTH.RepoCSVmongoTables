package Symptomate;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class TermsAndConditions extends BasePage {
	
	
	public String verifyTemsAndConditions() {
        
        String text = driver.findElement(By.xpath("//h3[.='Terms of Service']")).getText();
        
        return text;
    }

	
	
	
	
	
	
	
	
	
	
	
	public void cleanUp() {
		driver.quit();
	}

}
