package tel_page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameworkclasses.BasePage;

public class ApprovedPage extends BasePage {

	List<WebElement> offers;
	
	public int checkOffer() {
		waitForElement(10,By.xpath( "//section[@id='main']//form[@action='inserttariffplantocustomer.php']//table[@class='alt']/tbody/tr"));
		List<WebElement> offers=driver.findElements(By.xpath("//section[@id='main']//form[@action='inserttariffplantocustomer.php']//table[@class='alt']/tbody/tr"));
		
		return offers.size();
		
	}
	
	public void selectOffer() {
		
		driver.findElement(By.id("sele")).click();
		
	}
	
	public void addPlan() {
		
		driver.findElement(By.xpath("//section[@id='main']//form[@action='inserttariffplantocustomer.php']//input[@name='submit']"));
		
	}
	
}
