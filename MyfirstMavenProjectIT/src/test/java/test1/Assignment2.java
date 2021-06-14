package test1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import frameworkclasses.page_navigator;
import tel_page.AddTariffPage;
import tel_page.Add_customer;
import tel_page.Customer_ID;
import tel_page.Home_page;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Assignment2 {
	
	Home_page home = new Home_page();
	Add_customer addCustomer = new Add_customer();
	Customer_ID customerID = new Customer_ID();
	page_navigator pn = new page_navigator();
	AddTariffPage plan = new AddTariffPage();
	
	@BeforeTest
	public void testsetup() {
		home.clickCustomer();
        addCustomer.clickDone();
        addCustomer.filldata("junaid","fred", "junaid@gmail.com", "some text", "012");
        customerID.CustomerID();
        
	}
	
	@Test(priority = 0)
	public void gotoTariff() {
		pn.getFromprop("systemUnderTest");
		home.clickAddTariff();
		String ActualHeader1= addCustomer.getElementText(By.xpath("//span[@id='header']//a[@href='index.html']"));
		String Expectedh1= "Guru99 telecom";
		
		 Reporter.log("expected ------------------"+Expectedh1);
	        Reporter.log("actual --------------------"+ActualHeader1);
	        Assert.assertEquals(ActualHeader1, Expectedh1 ); 
	    
	}
	
	@Test(priority = 1)
	public void checkHeader() {
		
		String ActualHeader1= addCustomer.getElementText(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Tariff Plan to Customer']"));
		String Expectedh1= "Add Tariff Plan to Customer";
		
		 Reporter.log("expected ------------------"+Expectedh1);
	        Reporter.log("actual --------------------"+ActualHeader1);
	        Assert.assertEquals(ActualHeader1, Expectedh1 ); 
	}
	
	@Test(priority = 2)
	public void checkDoneCus() {
		
		String customerId = customerID.getId();
		plan.EnterCustomerID(customerId);
		plan.Submit();
		
		String active = plan.getElementText(By.xpath("//section[@id='main']/div[@class='inner']//font[.='ACTIVE']"));
		String expet= "ACTIVE";
		
		
		
		 Reporter.log("expected ------------------"+active);
	        Reporter.log("actual --------------------"+expet);
	        Assert.assertEquals(active, expet ); 
		
	}
	@Test(priority = 3)
public void checkPendingCus() {
		pn.getFromprop("systemUnderTest");
		home.clickCustomer();
        addCustomer.clickPending();
        addCustomer.filldata("junaid","fred", "junaid@gmail.com", "some text", "012");
        customerID.CustomerID();
	   
		pn.getFromprop("systemUnderTest");
		home.clickAddTariff();
		
		String customerId = customerID.getId();
		plan.EnterCustomerID(customerId);
		plan.Submit();
		
		String active = plan.getElementText(By.xpath("//section[@id='main']/div[@class='inner']//font[.='INACTIVE']"));
		String expet= "INACTIVE";
		
		
		
		 Reporter.log("expected ------------------"+active);
	        Reporter.log("actual --------------------"+expet);
	        Assert.assertEquals(active, expet ); 
		
	}

	}
	


