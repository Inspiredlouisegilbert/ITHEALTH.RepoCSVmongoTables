package TelcoProject;

import Telpage.AddCustomerDetails;
import Telpage.HomePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

public class assignment1 {

	HomePage home = new HomePage();
	AddCustomerDetails addCustDetails = new AddCustomerDetails();
	
	@Test(priority = 0)
	public void clickAddCustomer() {
		home.customer();
		
		String actual = addCustDetails.getheader(By.xpath("//span[@id='header']//a[@href='index.html']"));
		String expected = "Guru99 telecom";
		
		   Reporter.log("expected ------------------"+expected);
           Reporter.log("actual --------------------"+actual);
           Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 1)
	public void checkheader() {
		
		String actual = addCustDetails.getheader(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']"));
		String expected = "Add Customer";
		
		   Reporter.log("expected ------------------"+expected);
           Reporter.log("actual --------------------"+actual);
           Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 2)
	public void fillInDetails() {
		addCustDetails.clickDone();
		addCustDetails.filldata("polela", "mancoba", "ph@gmail.com", "65 Rosemead $$", "0785596854");
		
		
		String actual = addCustDetails.getMessage();
		String expected = "Special characters are not allowed";
		
		   Reporter.log("expected ------------------"+expected);
           Reporter.log("actual --------------------"+actual);
           Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 3)
	public void testAlert() {
		String actual = addCustDetails.getAlert();
		String expected = "please fill all fields";
		
		   Reporter.log("expected ------------------"+expected);
           Reporter.log("actual --------------------"+actual);
           Assert.assertEquals(actual, expected);
		
		
	}
	
	
	
}

