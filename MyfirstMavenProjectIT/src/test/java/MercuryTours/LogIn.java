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
		
		public void SelectSignOnLink(){
			clickElement(By.linkText("SIGN-ON"));
		}
		
		public void SelectSignOffLink(){
			clickElement(By.linkText("SIGN-OFF"));
		}
		
		public boolean IsSignOff(){
			return getElement(By.linkText("SIGN-OFF")).isDisplayed();
		}
		
		public boolean ValidateMessage(){
			return getElement(By.xpath("//h3[.='Login Successfully']")).isDisplayed();
		}
		
		public String ErrorMessage(){
			return getElementText(By.xpath("//form[@name='register']/table/tbody/tr[2]/td[2]/span[1]"));
		}
		
		
		public void login(String pUserName,String pPassword) {
			EnterUserDetails(pUserName);
			EnterUserPassword(pPassword);
			ClickSubmitButton();
		}
		
}
