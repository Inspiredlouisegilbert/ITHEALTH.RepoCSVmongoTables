package MercuryToursTests;

import org.junit.Assert;
import org.testng.annotations.Test;

import MercuryTours.RegisterPage;

public class Register {
     RegisterPage reg = new RegisterPage(); 
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



}
