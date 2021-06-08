package TelcoProject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.BasePage;

public class ApprovedTariffPlans extends BasePage {

List<WebElement> plans;
	
	public int checkPlan() {
		waitForElement(10,By.xpath( "//section[@id='main']//form[@action='inserttariffplantocustomer.php']//table[@class='alt']/tbody/tr"));
		List<WebElement> plans=driver.findElements(By.xpath("//section[@id='main']//form[@action='inserttariffplantocustomer.php']//table[@class='alt']/tbody/tr"));
		
		return plans.size();
		
	}
	public void waitForElement(int elementWait,By pLocator) {
		WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
    	
	}
	
	
	public void selectPlans() {
		
		driver.findElement(By.id("sele")).click();
		
	}
	
	public void addPlan() {
		
		driver.findElement(By.xpath("//section[@id='main']//form[@action='inserttariffplantocustomer.php']//input[@name='submit']"));
	}
	
}
