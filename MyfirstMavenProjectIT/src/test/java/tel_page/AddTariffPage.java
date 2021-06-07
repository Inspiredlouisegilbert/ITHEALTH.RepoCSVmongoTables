package tel_page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.BasePage;

public class AddTariffPage extends BasePage{
	

	public void EnterCustomerID(String pID) {
		
		driver.findElement(By.xpath("/html//input[@id='customer_id']")).sendKeys(pID);;
		
	}
	
	public void Submit() {
		
		driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		
	}
     
}
