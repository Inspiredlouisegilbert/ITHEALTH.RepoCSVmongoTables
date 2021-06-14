package pages;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class Results  extends BasePage {

	
	public String getResults () {
		
		 String text = driver.findElement(By.xpath("//h3[@class='header ng-binding']")).getText();
	        
	        return text;
	
	}
	
	
}
