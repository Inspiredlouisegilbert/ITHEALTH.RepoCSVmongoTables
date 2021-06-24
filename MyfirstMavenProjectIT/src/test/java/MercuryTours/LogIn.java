package MercuryTours;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class LogIn extends BasePage {
	
		public void EnterUserDetails(String pUsername){
			EnterText(By.xpath("//td[2]/input[@name='userName']"),pUsername);
		}
		
		public void EnterUserPassword(String pPassword){
			EnterText(By.xpath("//td[2]/input[@name='password']"),pPassword);
		}
		
		public void ClickSubmitButton(){
			clickElement(By.xpath("//input[@name='submit']"));
		}
}
