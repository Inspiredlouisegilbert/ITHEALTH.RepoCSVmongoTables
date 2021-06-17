package covidRelatedTests;

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

public class CovidTests {
	//instantiate needed pages
	HomePage newHomePage = new HomePage();
	PatientDetails newPatientDetails = new PatientDetails();
	Symptoms newSymptoms = new Symptoms();
	Results newResults = new Results();
	Introduction newIntroduction = new Introduction();
	TermsAndConditions newTermsAndConditions = new TermsAndConditions();
	
	@Test
	public void GIVEN_age70_AND_genderMale_AND_userNavigatedtoCovidCheckLanding_WHEN_userEntersDetails_THEN_HeIsAskedtoGoToHospital() {
		//Given	User open browsed to Symptomate
		String  actualHomeButton =  newHomePage.checkStartCheckup();
		String expectedHomeButton = "COVID-19 checkup";
		
		Assert.assertEquals(actualHomeButton, expectedHomeButton);
		
		Reporter.log("expected ------------------"+expectedHomeButton);
        Reporter.log("actual --------------------"+actualHomeButton);
		
		//		WHEN    User selects COVID-19 checkup button
        newHomePage.clickStartCheckUp();
        
		//		THEN	Introduction page is displayed with an anonymou message 
		//		AND     the user will receive an Interview ID
		//		WHEN	User clicks on Next button
		//		AND	  	User accepts the T&Cs 
		//		AND		Press the Next button
		//		AND 	Select the Male gender
		//		AND		User selects the 70 age 
		//		AND     Press Next BUTTON  
		//		AND    	Select Current cancer and Obesity as the options
		//		AND     Press Next Button 
		//		AND    	Leave page as is and Press Next button
		//		AND    	Symptoms page, select All to be yes
		//		AND    	Press the Next
		//		AND    	Select Headache and sore Throat
		//		AND		Press next button
		//		AND    	Select the 38.1 till 40 degrees
		//		AND 	Press Next Button
		//	    And	   	Select yes for heavy breathing 
		//		And	    Select yes for trouble with speaking due to heavy breathing problems
		//		and	    Select yes for daily activities making you feel dizzy
		//		AND    	Click yes for feeling confusing or overly sleepy 
		//		THEN    System done analysing data, 
		//		AND   	the user will be informed to go to a hospital
	}
	
	@AfterTest
	public void CleanUp()
	{
		newHomePage.cleanUp();
	}
}
