package TelcoProject;


import org.openqa.selenium.By;


import frameworkclasses.BasePage;



public class TelcoHomePage extends BasePage {
	
			
		public void clickAddCustomer() {
			
			driver.findElement(By.xpath("//section[@id='one']/div/div[@class='flex-item left']//a[@href='addcustomer.php']")).click();
		} 

		
public void clickAddTariffPlan() {
			
			
	
	driver.findElement(By.xpath("//section[@id='one']/div/div[@class='flex-item left']//a[@href='assigntariffplantocustomer.php']")).click();
		} 
	
		
	
		public void cleanUp() {
			driver.quit();
		}


	
	
}
	
	
	
	

