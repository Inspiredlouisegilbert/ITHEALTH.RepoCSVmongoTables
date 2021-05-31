package tel_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.xjc.Driver;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class Add_customer extends BasePage{
	
	String messageWarning = "";
	String AlertText = "";
	
	public String getheader1(By pLocator) {
		waitForElement(10,pLocator);
		String h1 = driver.findElement(pLocator).getText();
		
		return h1;
	}
	
	
	public void clickDone() {
		waitForClick(10, By.xpath("//section[@id='main']//form[@action='insertcustomer.php']/div[@class='row uniform']//label[.='Done']"));
		driver.findElement(By.xpath("//input[@id='done']")).click();
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
	
	public void filldata(String pName,String pLastName,String pEmail,String pMessage,String pNum) {
		
		driver.findElement(By.xpath("// input [@id='fname']")).sendKeys(pName);
		
		driver.findElement(By.xpath("// input [@id='lname']")).sendKeys(pLastName);
		
		driver.findElement(By.xpath("// input [@id='email']")).sendKeys(pEmail);
		
		driver.findElement(By.xpath("//section[@id='main']//form[@action='insertcustomer.php']/div[@class='row uniform']//textarea[@id='message']")).sendKeys(pMessage);
		
		waitForElement(10, By.xpath("// label [@id= 'message3']"));
		messageWarning = driver.findElement(By.xpath("// label [@id= 'message3']")).getText();
		
		driver.findElement(By.xpath("// input [@id='telephoneno']")).sendKeys(pNum);
		
		driver.findElement(By.xpath("// input [@id = 'submit']")).click();
		
		try {
			waitForAlert(10);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Alerts");
		} 

	}
	public String getMessage() {
		return messageWarning;
	}
	
	public String getAlert() {
		return AlertText;
	}
}
