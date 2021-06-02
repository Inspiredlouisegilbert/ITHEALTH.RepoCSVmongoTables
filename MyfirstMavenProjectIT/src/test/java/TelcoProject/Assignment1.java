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
	
	@Test(priority = 1)
	public void testHeader() {
//		addCustomer.clickDone();
	
		String ActualHeader2= customer.getheader1(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']"));
		String Expectedh2= "Add Customer";
		
		
		 Reporter.log("expected ------------------"+Expectedh2);
	        Reporter.log("actual --------------------"+ActualHeader2);
	        Assert.assertEquals(ActualHeader2, Expectedh2); 

	}
	
	@Test(priority = 2)
	public void testlabel() {
		customer.filldata("faith"," mayiyana", "faithm@gmail.com", "some text!!!!!!", "011");
		String Actuallabel= customer.getMessage();
		
		String Expectedlabel = "Special characters are not allowed";
		
		 Reporter.log("expected ------------------"+Expectedlabel);
	        Reporter.log("actual --------------------"+Actuallabel);
	        Assert.assertEquals(Actuallabel, Expectedlabel); 

	}
	
	@Test(priority = 3)
	public void testAlert() {
		String ActualAlert= customer.getAlert();
		
		String ExpectedAlert = "please fill all fields";

		 Reporter.log("expected ------------------"+ExpectedAlert);
	        Reporter.log("actual --------------------"+ActualAlert);
	        Assert.assertEquals(ActualAlert, ExpectedAlert);
	
	       
	        
	}
	@AfterSuite
    public void cleanup() {
         
        home.cleanUp();
    } 
}
