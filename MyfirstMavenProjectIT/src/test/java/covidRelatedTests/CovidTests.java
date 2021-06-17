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
        String actualIntroMessage = newIntroduction.checkIntroductionText();
        String expectedIntroMessage = "Our anonymous, reliable WHO-based tool can help you assess your risk of having COVID-19. By answering a few questions about symptoms, travel and contact with others, it shows you next steps to take.";
		
        Assert.assertEquals(actualIntroMessage, expectedIntroMessage);
        
        //		AND     the user will receive an Interview ID
        int actualId = newIntroduction.checkInterviewId().length();
        Assert.assertTrue(actualId>0);
        
		//		WHEN	User clicks on Next button
        newIntroduction.clickOnNextBtn();
		//		AND	  	User accepts the T&Cs
        newTermsAndConditions.clickCheckbox();
		//		AND		Press the Next button
        newIntroduction.clickOnNextBtn();
		//		AND 	Select the Male gender
        newPatientDetails.clickMale();
		//		AND		User selects the 70 age
        newPatientDetails.setAge(70);
		//		AND     Press Next BUTTON
        newPatientDetails.clickNext();
		//		AND    	Select Current cancer and Obesity as the options
       newSymptoms.clickCheckbox("choice_p_26");
       newSymptoms.clickCheckbox("choice_p_18");
		//		AND     Press Next Button 
       newSymptoms.clickNext();
		//		AND    	Leave page as is and Press Next button
       newSymptoms.clickNext();
		//		AND    	Symptoms page, select All to be yes
       newSymptoms.clickYesNoRadio(1, "yes");
       newSymptoms.clickYesNoRadio(2, "yes");
       newSymptoms.clickYesNoRadio(3, "yes");
		//		AND    	Press the Next
       newSymptoms.clickNext();
		//		AND    	Select Headache and sore Throat
       newSymptoms.clickCheckbox("choice_s_18");
       newSymptoms.clickCheckbox("choice_s_21");
		//		AND		Press next button
       newSymptoms.clickNext();
		//		AND    	Select the 38.1 till 40 degrees
       newSymptoms.selectTempRadio("choice_s_23");
		//		AND 	Press Next Button
       newSymptoms.clickNext();
		//	    And	   	Select yes for heavy breathing 
       newSymptoms.clickYesButton();
		//		And	    Select yes for trouble with speaking due to heavy breathing problems
       newSymptoms.clickYesButton();
		//		and	    Select yes for daily activities making you feel dizzy
       newSymptoms.clickYesButton();
		//		AND    	Click yes for feeling confusing or overly sleepy 
       newSymptoms.clickYesButton();
		//		THEN    System done analysing data, 
		//		AND   	the user will be informed to go to a hospital
       String actualResults = newResults.getResults();
       String expectedResults = "Head to the hospital. Avoid all contact.";
       
       Assert.assertEquals(actualResults, expectedResults);
	}
	
	//@AfterTest
	public void CleanUp()
	{
		newHomePage.cleanUp();
	}
}
