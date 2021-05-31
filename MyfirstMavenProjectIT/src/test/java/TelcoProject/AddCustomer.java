package TelcoProject;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class AddCustomer extends BasePage{

	String msgWarning ="";
	String AlertText = "";
	
	
public String getHeader1(By pLocator) {
	String h1 =driver.findElement(pLocator).getText();
	
	return h1;
}

public void clickDoneBtn() {
	driver.findElement(By.xpath("//input[@id='done']")).click();
}
	
public void waitForElement(int elementWait,By pLocator)	{
}
	
}
