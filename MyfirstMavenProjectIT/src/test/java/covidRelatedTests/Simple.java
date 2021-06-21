package covidRelatedTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
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
	
//	@AfterTest
//	public void CleanUp()
//	{
//		newHomePage.org.openqa.selenium.NoSuchSessionException: invalid session id
//	}
}
