package MercuryToursTests;

import org.junit.Assert;
import org.testng.annotations.Test;

import MercuryTours.LogIn;
import MercuryTours.RegisterPage;

public class Tests {
     RegisterPage reg = new RegisterPage(); 
     LogIn loginScreen = new LogIn();
     //|Junaid 	|Brazil		|juanid@gmail.com  |password@4
     String name="junaid",lastName= "fredericks",country="BRAZIL", email= "junaid@gmail.com", password="password@4";
     @Test
     public void RegisterTest() {
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
    	 reg.register(name, lastName,country, email, password);
    	 
// 	    THEN The message will be displayed "Thank you for registering"
    	 String actual = reg.pageURL();
    	 String expected = "http://demo.guru99.com/test/newtours/register_sucess.php";
    	 Assert.assertEquals(actual,expected);
     }
     
     
     
     public void SignIn() {
    	 RegisterTest();
//    	 Test Case 2 : Sign On
//    	 Feature :As a user I would like to sign on the tours web site
//    	 Scenario Outline :The user will enter valid username and password they registered with;then they will sign in.
//    	        When User clicks on the hyperlink "SIGN ON"
    	 loginScreen.SelectSignOnLink();
//    	 		AND User enter valid username and password
    	 loginScreen.login(email,password);
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
    	 
     }



}