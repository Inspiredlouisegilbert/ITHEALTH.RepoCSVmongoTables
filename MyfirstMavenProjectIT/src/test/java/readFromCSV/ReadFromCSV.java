package readFromCSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.SeleniumFunctions;


public class ReadFromCSV {
	String pURL = "http://demo.guru99.com/V1/index.php";
	
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
	

	
	// Read from CSV methods
	public void navigateToURL(String pURL) throws IOException {
		
		this.driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();	
		sfSelenium.logScreenShot();
		
	}
	
	public void clickLogin() {
		
		this.driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}
	
	public void captureDetails(String pUsername, String pPassword) throws IOException {
		navigateToURL(pURL);
		sfSelenium.populateInputField(By.name("uid"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		
		clickLogin();
		
		
	}
	
	public void waitForAlert(int elementWait) {
		WebDriverWait wait = new WebDriverWait(this.driver,elementWait);
    	wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void validateMessage(String pMessage) throws InterruptedException, IOException {

		boolean isSuccessCase = pMessage.equals("successful login");
 
   
        if(isSuccessCase) {
    		try   
  		  {    
  		    if(this.driver.findElement(By.xpath("//img[1mm]")).isDisplayed() )     
  		    {      
  		    	sfSelenium.createTest("Is a Positive test case");
  	        	sfSelenium.logScreenShot();
  		    }    
  		  }      
  		  catch(Exception e)     
  		  {       
  			  sfSelenium.createTest("Is a Positive test case");
  			  sfSelenium.doValidation("Success Case Failed", "Image not found");
  			  sfSelenium.logScreenShot();
  			  
  		  }       
  		}  
        	
        else
        {
	   		sfSelenium.createTest("Is a Negative test case");
	       	// wait for the alert
	       	waitForAlert(10);
	       	//handle the alert message
	       	Alert alert = this.driver.switchTo().alert();
	   		String sAlertMessage = alert.getText();
	   		
	   		
	   		System.out.println(sAlertMessage);
	   		Thread.sleep(500);
	   		
	   		alert.accept();  
	   		sfSelenium.doValidation(sAlertMessage, "User is not valid");
	        	
        }
		
	}
	
	public void readCSV() throws IOException, InterruptedException {

		
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
		
		System.out.println(p.getProperty("csvLoc"));
		
		BufferedReader br = new BufferedReader(new FileReader(p.getProperty("csvLoc"))); 
		String line;
		while ((line = br.readLine()) != null) { 
		    // use xx as separator 
		    // Task change the delimiter to a ,
			// assign a variable to each field value
			System.out.println(line);
			
			String[] cols = line.split(";"); 
		    String pUsername = cols[0];
		    String pPassword = cols[1];
		    String pMessage = cols[2];
		    captureDetails(pUsername, pPassword);
		    
		    validateMessage(pMessage);
		    //System.out.println(username + " " + password + " " + pMessage);
		    navigateToURL(pURL);
		    
		    
	}
		
		
		
}
	
	
	// Run Test Section
	public void runTest() throws IOException, InterruptedException {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From CSV Report", "CSV Report");
		sfSelenium.createTest("Test Started: Read From CSV Report");
		
		navigateToURL(pURL);
		readCSV();
		sfSelenium.createTest("Test Ended: Read From CSV Report");
		sfSelenium.CloseSelenium();
		
	}

}