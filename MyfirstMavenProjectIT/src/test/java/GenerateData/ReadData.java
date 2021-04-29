package GenerateData;

import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;


public class ReadData {
	String pURL = "http://demo.guru99.com/V1/index.php";
	String email = this.generateRandomData();
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("chrome");
	
	// driver variable
	WebDriver driver;
	
	public String getProperties(String pPropertyKey) {
		// Properties setup
				Properties p = new Properties();
				InputStream is = null;
				try {
					is = new FileInputStream("dataConfig.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p.load(is);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return p.getProperty(pPropertyKey);
	}

	//neviagting to the URL
	public void nevigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();	
	}
	

	//click on directory Link
	public void linkClick() {
		sfSelenium.clickLink("here");
	}
	

	//Login with email and click submit button
	
public void fillDetails(String pValue, String pName) {
	sfSelenium.populateInputField(By.name(pName), pValue);
	
}

public void submitBtn() {

	this.driver.findElement(By.name("btnLogin")).click();
}

public String getTextFromTable(String pCss) {
	return driver.findElement(By.cssSelector(pCss)).getText();
	
}
public void validateLogin()
{
	try   
	  {    
	    if(this.driver.findElement(By.xpath("//img[1]")).isDisplayed() )     
	    {      
	    	sfSelenium.createTest("Is a Positive test case");
        	sfSelenium.logScreenShot();
	    }   
	    
	 	
        else
        {
	   		sfSelenium.createTest("Is a Negative test case");
	       	// wait for the alert
	       	//waitForAlert(10);
	       	//handle the alert message
	       	Alert alert = this.driver.switchTo().alert();
	   		String sAlertMessage = alert.getText();
	   		
	   		
	   		System.out.println(sAlertMessage);
	   		Thread.sleep(500);
	   		
	   		alert.accept();  
	   		sfSelenium.doValidation(sAlertMessage, "User is not valid");
	        	
        }
	  } 
	
	  catch(Exception e)     
	  {       
		  sfSelenium.createTest("Is a Positive test case");
		  sfSelenium.doValidation("Success Case Failed", "Image not found");
		  
	  }       
	}  

public String generateRandomData() {
	String staticEmail = "junaid";
	String staticDomain= "@gmail.com";		
	int min= 0;
	int max = 1000;
	int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
	
	return staticEmail+randomNum+staticDomain;
}

	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	

	
	@Test (priority =1)
	public void staticData() throws Exception {
		System.out.println("Test");
		nevigateToURL(pURL);
		linkClick();
		fillDetails(email,"emailid");
		submitBtn();
		
	}
	
	@Test (priority = 2)
	public void positiveInputData()
	{
		String username = getTextFromTable("body > table > tbody > tr:nth-child(4) > td:nth-child(2)");
		String password = getTextFromTable("body > table > tbody > tr:nth-child(5) > td:nth-child(2)");
		nevigateToURL(pURL);
		fillDetails(username,"uid");
		fillDetails(password,"password");
		submitBtn();
		validateLogin();
		
	}
	
	@Test (priority = 3)
	public void negativeInputData()
	{
		String invalidpassword = "pass";
		String invalidusername = "username";
		
		nevigateToURL(pURL);
		fillDetails(invalidusername,"uid");
		fillDetails(invalidpassword,"password");
		submitBtn();
		validateLogin();
		
	}


	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
		
	}

}