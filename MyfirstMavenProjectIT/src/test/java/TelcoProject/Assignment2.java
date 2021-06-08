package TelcoProject;
import pages.SignInPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Assignment2 {


	TelcoHomePage home = new TelcoHomePage();
	
	AddTariffPlan plan = new AddTariffPlan();
	
	AddCustomer customer = new AddCustomer();
	
	CustomerID customerId = new CustomerID();
	
	@BeforeTest
	public void testsetup() {
		home.clickAddCustomer();
        customer.clickDoneBtn();
        customer.filldata("faith","gangxa", "gangxaf@gmail.com", "some text", "0112");
        customerId.CustomerID();
	
	}
	
	//This  test case checks the header of the page if its correct Guru99 telecom
	@Test(priority = 0)
	public void testHeader3() {
		plan.goToHomePage();
		home.clickAddTariffPlan();
		String ActualHeader= plan.getheader1(By.xpath("//span[@id='header']//a[@href='index.html']"));
		String Expectedh= "Guru99 telecom";

		
		 Reporter.log("expected ------------------"+Expectedh);
	        Reporter.log("actual --------------------"+ActualHeader);
	        Assert.assertEquals(ActualHeader, Expectedh); 

	}

	//This checks the header of Tariff Plan 
 @Test(priority = 1)
public void testHeader4() {	
	    		
	String ActualHeader1= plan.getheader1(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Tariff Plan to Customer']"));
	String Expectedh1= "Add Tariff Plan to Customer";
		    		
		    		
	Reporter.log("expected ------------------"+Expectedh1);
	Reporter.log("actual --------------------"+ActualHeader1);
	Assert.assertEquals(ActualHeader1, Expectedh1); 
	    	}

    //This test case fill in the correct customer id on the form and confirms the status if its active

	@Test(priority = 2)
	public void checkActiveCustomer() {
		
		String customerId = CustomerID.getId();
		plan.EnterCustomerNO(customerId);
		plan.SubmitCustomer();
		
		String active = plan.getheader1(By.xpath("//section[@id='main']/div[@class='inner']//font[.='ACTIVE']"));
		String expet= "ACTIVE";
		
		
		
		 Reporter.log("expected ------------------"+active);
	        Reporter.log("actual --------------------"+expet);
	        Assert.assertEquals(active, expet ); 
		
	}
	
    //This test case fill in the correct customer id on the form and confirms the status if its inactive
	@Test(priority = 4)
	public void checkInactiveCustomer() {
			customer.goToHomePage();
			home.clickAddCustomer();
	        customer.clickPending();
	        customer.filldata("faith","mayiyana", "faith@gmail.com", "some text", "012");
	        customerId.CustomerID();

		
	    customer.goToHomePage();
		home.clickAddTariffPlan();

		String customerId = CustomerID.getId();
		plan.EnterCustomerNO(customerId);
		plan.SubmitCustomer();
		
		
		String active = plan.getheader1(By.xpath("//section[@id='main']/div[@class='inner']//font[.='INACTIVE']"));
		String expet= "INACTIVE";
		
		 Reporter.log("expected ------------------"+active);
	        Reporter.log("actual --------------------"+expet);
	        Assert.assertEquals(active, expet ); 
	
	}
	
	
		
	@AfterSuite
	 public void cleanup() {
	         
	 home.cleanUp();
	    } 
}
