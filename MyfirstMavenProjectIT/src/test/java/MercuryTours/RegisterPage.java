package MercuryTours;

import org.openqa.selenium.By;


import frameworkclasses.BasePage;

public class RegisterPage extends BasePage{
	
	public String pageURL() {
		return driver.getCurrentUrl();
	}
	public void enterName(String pName) {
		EnterText(By.xpath("//input[@name='firstName']"), pName);
	}
	
	public void enterLastName(String plastName) {
		EnterText(By.xpath("//input[@name='lastName']"), plastName);
	}
	
	public void enterPhone(String pPhone) {
		EnterText(By.xpath("//input[@name='phone']"), pPhone);
	}
	
	public void enterEmail(String pEmail) {
		EnterText(By.xpath("//input[@name='userName']"), pEmail);
	}
	
	public void enterAddress(String pAddress) {
		EnterText(By.xpath("//input[@name='address1']"), pAddress);
	}
	
	public void enterCity(String pCity) {
		EnterText(By.xpath("//input[@name='city']"), pCity);
	}
	
	public void enterState(String pState) {
		EnterText(By.xpath("//input[@name='state']"), pState);
	}
	
	public void enterPostal(String pPostal) {
		EnterText(By.xpath("//input[@name='postalCode']"), pPostal);
	}
	
	public void enterUser(String pUser) {
		EnterText(By.xpath("//input[@name='email']"), pUser);
	}
	
	public void enterPassword(String pPassword) {
		EnterText(By.xpath("//input[@name='password']"), pPassword);
	}
	
	public void enterConPassword(String pPassword) {
		EnterText(By.xpath("//input[@name='confirmPassword']"), pPassword);
	}
     
	public void selectCountry(String pValue) {
		selectDropDown(By.xpath("//input[@name='country']"), pValue);
	}
	
	public void enterSubmit() {
		clickElement(By.xpath("//input[@name='submit']"));
	}
	
	public void clickRegister() {
		clickElement(By.xpath("//a[@href='register.php'"));
	}
	
	public void register(String pName, String pLastName,String pCountry,String pEmail,String pPassword) {
		enterName(pName);
		enterLastName(pLastName);
		//enterPhone(pPhone);
		enterEmail(pEmail);
		//enterAddress(PAddress);
		//enterCity(pCity);
		//enterState(pState);
		//enterPostal(pPostal);
		selectCountry(pCountry);
		enterUser(pEmail);
		enterPassword(pPassword);
		enterConPassword(pPassword);
		enterSubmit();
	}
	}
