package TelcoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.BasePage;

public class CustomerID extends BasePage {

static String customerID = "";
	
   public void waitForElement(int elementWait,By pLocator) {
   WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
   wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
 	
}
	
	public void CustomerID() {
		
		waitForElement(10,By.xpath("//tr[1]/td[2]"));
		customerID = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
		
	}
	
	public static String getId() {
		return customerID;
	}

	
}
