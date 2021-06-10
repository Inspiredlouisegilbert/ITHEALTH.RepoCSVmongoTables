package Symptomate;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.BasePage;
import pages.SignInPage;

public class Introduction extends BasePage {

	
	//First Test. This test case verifies the introduction title page
    public String getTitle() {
        return driver.getTitle();
		} 
	
    
    //Checks the text on the Introduction page
    public String checkIntroductionText() {
        
    	return driver.findElement(By.xpath("//p[@class='ng-scope']")).getText();
    }
	
    public String checkInterviewId() {
    	
    	return driver.findElement(By.cssSelector("[render-html='interviewId']")).getText();
    }

    //Click on Next button
    public TermsAndConditions clickOnNextBtn() {
        
    	driver.findElement(By.xpath("//div[@class='form has-side-menu']/div[2]//button[2]")).click();
        
        //clicking on Next button will display Terms and Conditions
        return new TermsAndConditions();
    }
    
    
    
    
}
