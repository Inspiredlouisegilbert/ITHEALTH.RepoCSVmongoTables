package MercuryToursTests;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.annotations.Test;

import MercuryTours.LogIn;
import MercuryTours.RegisterPage;
import MercuryTours.FlightsPage;

public class Tests {
     RegisterPage reg = new RegisterPage(); 
     LogIn loginScreen = new LogIn();
     FlightsPage flights = new FlightsPage();
     //|Junaid 	|Brazil		|juanid@gmail.com  |password@4
    // String name="junaid",lastName= "fredericks",country="BRAZIL", email= "junaid@gmail.com", password="password@4",invalidemail="faith.com",invalidpassword ="pass";
     //@Test(dataProvider="ToursValidUsers", dataProviderClass=dataProviders.NewToursDataProvider.class)
     public void RegisterTest(String pName,String pCountry,String pEmail,String pPassword) {
//    	 WHEN User clicks on the hyperlink "REGISTER"
    	 reg.clickRegister();
    	 
// 		THEN Registration page is displayed
    	 String actualRegisterPage = reg.pageURL();
    	 String expectedRegisterPage = "http://demo.guru99.com/test/newtours/register.php";   	 
    	 Assert.assertEquals(actualRegisterPage, expectedRegisterPage);
    	 
// 		WHEN  The user will fill in the "Contact Information"
// 		AND  The user will fill in the "Mailing Information"
// 		AND  The user will fill in the "User Information"
// 		AND  The user will click the submit button
    	 reg.register(pName, pCountry,pEmail, pPassword);
    	 
// 	    THEN The message will be displayed "Thank you for registering"
    	 String actual = reg.pageURL();
    	 String expected = "http://demo.guru99.com/test/newtours/register_sucess.php";
    	 Assert.assertEquals(actual,expected);
     }
     
     
     @Test(dataProvider="ToursValidUsers", dataProviderClass=dataProviders.NewToursDataProvider.class)
     public void RegisterAndSignIn(String pName,String pCountry,String pEmail,String pPassword) {
    	 RegisterTest(pName, pCountry,pEmail, pPassword);
//    	 Test Case 2 : Sign On
//    	 Feature :As a user I would like to sign on the tours web site
//    	 Scenario Outline :The user will enter valid username and password they registered with;then they will sign in.
//    	        When User clicks on the hyperlink "SIGN ON"
    	 loginScreen.SelectSignOffLink();
//    	 		AND User enter valid username and password
    	 loginScreen.login(pEmail,pPassword);
//    	 		AND User clicks on the submit button
//    	 		THEN Log in page will be displayed
    	 Assert.assertTrue(loginScreen.IsSignOff());
//    	 		AND The message will be displayed "Login Successfully"
    	 Assert.assertTrue(loginScreen.ValidateMessage());
    	  
//    	 Examples:
//    	 		|Username          | Password
//    	 		|polela@gmail.com  |password@1
//    	 		|faith@gmail.com   |password@2
//    	 		|mvuyo@gmail.com   |password@3
//    	 		|juanid@gmail.com  |password@4
    	 loginScreen.SelectSignOffLink();
     }
     
     @Test(dataProvider="ToursInvalidUsers", dataProviderClass=dataProviders.NewToursDataProvider.class)
     public void IncorrectLogin(String pUsername,String pPassword) throws InterruptedException {
//    	 Feature :A user will enter incorrect username or password on the tours web site
//    	 Scenario Outline : The user will enter incorrect username or password ;then they will not be able to sign in.
    	 loginScreen.SelectSignOnLink();
//   	 When User enters invalid username or password
    	 loginScreen.login(pUsername,pPassword);
//	 		AND User clicks on the submit button
//    	 THEN  An error message will be displayed "Enter your userName and password correct"
    	 String actual = loginScreen.ErrorMessage();
	 String expected = "Enter your userName and password correct";
	 
	 Assert.assertEquals(actual,expected);
     Thread.sleep(1000);

}
     
     @Test(dataProvider="ToursInvalidUsers", dataProviderClass=dataProviders.NewToursDataProvider.class)
     public void findFlight(String sFromPort, String sFromMonth, String sFromDay, String sToPort, String sToMonth, String sToDay) {
    	//When User clicks on the hyperlink "Flights"
    	 flights.clickFlights();
    	 
    	//THEN Flight Finder page is displayed
    	 assertTrue(flights.verifyFlightsPage());
    	
    	//AND The user will fill in the "Flight Details"
    	//AND The user will fill in the "Preferences"
    	//AND The user will click the continue button
    	 flights.CaptureFlightDetails(sFromPort, sFromMonth, sFromDay, sToPort, sToMonth, sToDay);
    	 Assert.assertTrue(flights.verifyFlightSuccess());
     }
}
