package CovidPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import frameworkclasses.BasePage;

public class TermsAndConditions extends BasePage {
	
	
	public String verifyTemsAndConditions() {
        
        String text = driver.findElement(By.xpath("//h3[.='Terms of Service']")).getText();
        
        return text; 
    }

	public void clickCheckbox() {
		//clickElement(By.xpath("//label [@for ='choice_99991_99991'")); 
		WebElement yourChkBox  = driver.findElement(By.cssSelector("form[name='screenForm'] > .checkbox-label.ng-scope"));
        Actions act = new Actions(driver);
        act.moveToElement(yourChkBox).moveByOffset(0, 40).click().build().perform();
}

	public boolean isButtonEnable(By pLocator) {
        //change null to checkbox locator
        //pLocator should be for the button
        return driver.findElement(pLocator).isEnabled();
    }
	
	
	
	public void cleanUp() {
		driver.quit();
	}

}
