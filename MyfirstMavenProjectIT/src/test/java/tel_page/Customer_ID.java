package tel_page;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class Customer_ID extends BasePage{
	
	String customerID = "";
	
//	public void waitForElement(int elementWait,By pLocator) {
//		WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
//    	
//	}
//	
//	public void waitForClick(int elementWait,By pLocator) {
//		WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
//    	wait.until(ExpectedConditions.elementToBeClickable(pLocator));
//    	
//	}
//	
//	public String getheader1(By pLocator) {
//		waitForElement(10,pLocator);
//		String h1 = driver.findElement(pLocator).getText();
//		
//		return h1;
//	}
	
	public void CustomerID() {
		
		waitForElement(10,By.xpath("//tr[1]/td[2]"));
		customerID = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
		
	}
	
	public String getId() {
		return customerID;
	}
}
