package CovidPage;

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
        
    	return getElementText(By.xpath("//p[@class='ng-scope']"));
    }
	
    public String checkInterviewId() {
    	
    	return getElementText(By.cssSelector("[render-html='interviewId']"));
    }

    //Click on Next button
    public void clickOnNextBtn() {
        
    	clickElement(By.xpath("//div[@class='form has-side-menu']/div[2]//button[2]"));       
    }
    
    
    
    
}