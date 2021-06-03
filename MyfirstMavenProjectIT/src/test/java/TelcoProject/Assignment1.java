package TelcoProject;
import org.testng.annotations.*;

import pages.SignInPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;



public class Assignment1 {

	TelcoHomePage home = new TelcoHomePage();
	
	AddCustomer customer = new AddCustomer();

	AddTariffPlan plan = new AddTariffPlan();

	//Assignement 1
	//This  test case checks the header of the page if its correct Guru99 telecom
	@Test(priority = 0)
	public void testHeader1() {
		home.clickAddCustomer();
		String ActualHeader1= customer.getheader1(By.xpath("//span[@id='header']//a[@href='index.html']"));
		String Expectedh1= "Guru99 telecom";
		customer.clickDoneBtn();

		
		 Reporter.log("expected ------------------"+Expectedh1);
	        Reporter.log("actual --------------------"+ActualHeader1);
	        Assert.assertEquals(ActualHeader1, Expectedh1 ); 

	}
	//This test case checks the header of if its correct Add Customer
	@Test(priority = 1)
	public void testHeader() {	
		String ActualHeader2= customer.getheader1(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']"));
		String Expectedh2= "Add Customer";
		
		
		 Reporter.log("expected ------------------"+Expectedh2);
	        Reporter.log("actual --------------------"+ActualHeader2);
	        Assert.assertEquals(ActualHeader2, Expectedh2); 

	}
	//This test case fill in positive data into the form 
	@Test(priority = 2)
	public void testlabel() {
		customer.filldata("faith","mayiyana", "faithm@gmail.com", "some text", "011");
	}
	//Assignment 2
	//This  test case checks the header of the page if its correct Guru99 telecom
	@Test(priority = 4)
	public void testHeader3() {
		plan.goToHomePage();
		home.clickAddTariffPlan();
		String ActualHeader3= plan.getheader2(By.xpath("//span[@id='header']//a[@href='index.html']"));
		String Expectedh3= "Guru99 telecom";

		
		 Reporter.log("expected ------------------"+Expectedh3);
	        Reporter.log("actual --------------------"+ActualHeader3);
	        Assert.assertEquals(ActualHeader3, Expectedh3 ); 

	}

	//This checks the header of Tariff Plan 
	    	@Test(priority = 6)
	    	public void testHeader4() {	
	    		
	    		String ActualHeader4= plan.getheader2(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Tariff Plan to Customer']"));
	    		String Expectedh4= "Add Tariff Plan to Customer";
	    		
	    		
	    		 Reporter.log("expected ------------------"+Expectedh4);
	    	        Reporter.log("actual --------------------"+ActualHeader4);
	    	        Assert.assertEquals(ActualHeader4, Expectedh4); 
	    	}
    //This test case fill in the correct customer id on the form
	    	    	@Test(priority = 7)
	    	    	public void testdetail() {
	    	    		plan.filldetail("760133");
	    	    		
	}        
 	             
	
	@AfterSuite
    public void cleanup() {
         
        home.cleanUp();
    } 
}

