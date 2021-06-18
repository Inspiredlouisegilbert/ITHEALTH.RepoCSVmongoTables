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

	public void clickCheckbox() throws InterruptedException {
		
        clickElement(By.xpath("//label[1]"));
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
