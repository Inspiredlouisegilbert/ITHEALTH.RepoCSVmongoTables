package Symptomate;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class HomePage  extends BasePage {

	
	public String clickStartCheckup() {
		
		 String text = driver.findElement(By.xpath("//a[@href='/covid19/checkup/']")).getText();
	     return text;
		
	} 
	
	
	
}
