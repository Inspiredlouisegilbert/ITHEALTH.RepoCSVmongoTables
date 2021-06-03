package test1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import frameworkclasses.page_navigator;
import tel_page.Add_customer;
import tel_page.Home_page;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

public class Assignment1 {
   
	Home_page home = new Home_page();
	Add_customer addCustomer = new Add_customer();
	
	@Test(priority = 0)
	public void testHeader1() {
		home.clickCustomer();
		String ActualHeader1= addCustomer.getheader(By.xpath("//span[@id='header']//a[@href='index.html']"));
		String Expectedh1= "Guru99 telecom";
		addCustomer.clickDone();

		
		 Reporter.log("expected ------------------"+Expectedh1);
	        Reporter.log("actual --------------------"+ActualHeader1);
	        Assert.assertEquals(ActualHeader1, Expectedh1 ); 
	    
	}
	
	@Test(priority = 1)
	public void testHeader() {
//		addCustomer.clickDone();

		String ActualHeader2= addCustomer.getheader(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']"));
		String Expectedh2= "Add Customer";
		
		
		 Reporter.log("expected ------------------"+Expectedh2);
	        Reporter.log("actual --------------------"+ActualHeader2);
	        Assert.assertEquals(ActualHeader2, Expectedh2); 
	    

	}
	
	@Test(priority = 2)
	public void testlabel() {
		addCustomer.filldata("junaid","fred", "junaid@gmail.com", "some text!!!!!!", "012");
		String Actuallabel= addCustomer.getMessage();
		
		String Expectedlabel = "Special characters are not allowed";
		
		 Reporter.log("expected ------------------"+Expectedlabel);
	        Reporter.log("actual --------------------"+Actuallabel);
	        Assert.assertEquals(Actuallabel, Expectedlabel); 

	}
	
	@Test(priority = 3)
	public void testAlert() {
		String ActualAlert= addCustomer.getAlert();
		
		String ExpectedAlert = "please fill all fields";

		 Reporter.log("expected ------------------"+ExpectedAlert);
	        Reporter.log("actual --------------------"+ActualAlert);
	        Assert.assertEquals(ActualAlert, ExpectedAlert); 

	}
	
	
	}
