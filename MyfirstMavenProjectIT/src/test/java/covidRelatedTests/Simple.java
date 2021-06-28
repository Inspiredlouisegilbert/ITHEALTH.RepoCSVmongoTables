package covidRelatedTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CovidPage.HomePage;
import CovidPage.Introduction;
import CovidPage.PatientDetails;
import CovidPage.Results;
import CovidPage.Symptoms;
import CovidPage.TermsAndConditions;

public class Simple {
	//instantiate needed pages
	HomePage newHomePage = new HomePage();
	PatientDetails newPatientDetails = new PatientDetails();
	Symptoms newSymptoms = new Symptoms();
	Results newResults = new Results();
	Introduction newIntroduction = new Introduction();
	TermsAndConditions newTermsAndConditions = new TermsAndConditions();
	
	@Test
	public void GIVEN_age70_AND_genderMale_AND_userNavigatedtoCovidCheckLanding_WHEN_userEntersDetails_THEN_HeIsAskedtoGoToHospital() throws InterruptedException {
		//Given	User open browsed to Symptomate
		String  actualHomeButton =  newHomePage.checkStartCheckup();
		String expectedHomeButton = "COVID-19 checkup";
		
		Assert.assertEquals(actualHomeButton, expectedHomeButton);
		
		Reporter.log("expected ------------------"+expectedHomeButton);
        Reporter.log("actual --------------------"+actualHomeButton);
		
	}
	
	@Test(dataProvider="SearchProvider")
    public void testMethod(String author,String searchKey) throws InterruptedException{
    {
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
    }
    }
	
	@Test(dataProvider="SearchProviderDifferent")
    public void testMethodDifferentData(String GreenGrocer) throws InterruptedException{
    {
        System.out.println("Would you like "+ GreenGrocer);
    }
    }
	
	@Test(dataProvider="SearchProviderClass", dataProviderClass=dataProviders.DemoDataProviders.class)
    public void testMethodClass(String author,String searchKey) throws InterruptedException{
    {
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
    }
    }
	
	@Test(dataProvider="SearchProviderDifferentClass", dataProviderClass=dataProviders.DemoDataProviders.class)
    public void testMethodDifferentDataClass(String GreenGrocer) throws InterruptedException{
    {
        System.out.println("Would you like "+ GreenGrocer);
    }
    }
	
	
	
	
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };
    }
    
    @DataProvider(name="SearchProviderDifferent")
    public Object[][] getDataFromDataproviderDifferent(){
    return new Object[][] 
    	{
            { "an Apple"},
            { "a Banana"},
            { "a bunch of Grapes"}
        };
    }
    

    
	
	
//	@AfterTest
//	public void CleanUp()
//	{
//		newHomePage.org.openqa.selenium.NoSuchSessionException: invalid session id
//	}
}
