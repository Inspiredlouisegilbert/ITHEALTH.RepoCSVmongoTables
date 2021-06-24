package MercuryToursTests;

import org.testng.annotations.Test;

import MercuryTours.RegisterPage;

public class Register {
     RegisterPage reg = new RegisterPage();
     
     @Test
     public void RegisterTest() {
    	 reg.clickRegister();
    	 reg.register(null, null, null, null, null, null, null, null, null, null, null, null);
     }
}
