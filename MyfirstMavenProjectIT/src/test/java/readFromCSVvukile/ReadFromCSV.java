package readFromCSVvukile;

import java.util.List;
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

import frameworkclasses.ExtentReportClass;
import frameworkclasses.SeleniumFunctions;


public class ReadFromCSV {
	String pURL = "http://demo.guru99.com/V1/index.php";
	
	//report declaration
	//ExtentReportClass extReports = new ExtentReportClass();
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
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
	

	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		this.driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();	
	}
	
	public void clickLogin() {
		
		this.driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}
	
	public void captureDetails(String pUsername, String pPassword) {
		
		sfSelenium.populateInputField(By.name("uid"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		
		clickLogin();
		
		
	}
	
	public void validateMessage(String pMessage) throws InterruptedException {

		boolean isSuccessCase = pMessage.equals("successful login");
   
        if(isSuccessCase) {
        	//need to perform an asert
        	this.driver.findElement(By.xpath("//img[1]"));
        }
        else
        {
        	//handle the alert message
        	Alert alert = this.driver.switchTo().alert();
    		String sAlertMessage = alert.getText();
    		
    		
    		System.out.println(sAlertMessage);
    		Thread.sleep(500);
    		
    		alert.accept();
        	
        }
		
	}

	
	public void runTest() throws IOException, InterruptedException {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From CSV Report", "CSV Report");
		sfSelenium.createTest("Start Test");
		// Set URL
		//String pURL = "http://demo.guru99.com/V1/index.php";
		
		navigateToURL(pURL);
		readCSV();
		sfSelenium.CloseSelenium();
		
		
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

}