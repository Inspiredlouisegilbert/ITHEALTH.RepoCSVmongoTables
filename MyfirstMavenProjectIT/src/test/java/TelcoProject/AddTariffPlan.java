package TelcoProject;

import frameworkclasses.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTariffPlan extends BasePage {

	String msgWarning ="";
	String AlertText = "";
	String customerNo = "";

	
	public String getheader1(By pLocator) {
		waitForElement(10,pLocator);
		String h1 = driver.findElement(pLocator).getText();
		
		return h1;
	}
	
	public void waitForElement(int elementWait,By pLocator) {
		WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
    	
	}
	
	public void waitForClick(int elementWait,By pLocator) {
		WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
    	wait.until(ExpectedConditions.elementToBeClickable(pLocator));
    	
	}
	public void waitForAlert(int elementWait) {
		WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
    	wait.until(ExpectedConditions.alertIsPresent());
    	AlertText = driver.switchTo().alert().getText();
    	driver.switchTo().alert().accept();
	}
	
public void filldetail(String pCustomerNo) {
		
		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(pCustomerNo);
		driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();

}


public void EnterCustomerNO(String pID) {
	
	driver.findElement(By.xpath("/html//input[@id='customer_id']")).sendKeys(pID);
}

public void SubmitCustomer() {
	
	driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
	
}

	public void goToHomePage() {
		waitForClick(30, By.xpath("//span[@id='header']//a[@href='index.html']"));
		driver.findElement(By.xpath("//span[@id='header']//a[@href='index.html']")).click();
	}
}
