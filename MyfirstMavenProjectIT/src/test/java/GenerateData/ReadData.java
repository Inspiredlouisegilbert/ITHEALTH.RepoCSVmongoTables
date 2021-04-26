package GenerateData;

import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
	String email = "f@gmail.com" ;
	
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
	
public void fillDetails(String email) {
	sfSelenium.populateInputField(By.name("emailid"), email);
	
}

public void submitBtn() {

	this.driver.findElement(By.name("btnLogin")).click();
}

	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	

	
	@Test
	public void testOne() throws Exception {
		System.out.println("Test");
		nevigateToURL(pURL);
		linkClick();
		fillDetails(email);
		submitBtn();
	}
	

	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}

}