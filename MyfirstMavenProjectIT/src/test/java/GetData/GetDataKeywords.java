package GetData;


import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;

public class GetDataKeywords {
	
	//private String stringggg;
	// Selenium Functions 
	//this.SeleniumFunctions() = sfSelenium;
	
	//SeleniumFunctions sfSelenium = new SeleniumFunctions(stringggg);
	SeleniumFunctions sfSelenium = new SeleniumFunctions("chrome");
//	
//	// driver variable
	WebDriver driver;
//	
//	
//	// Set URL
	String pURL = "http://demo.guru99.com/V1/index.php";
	
	
	
	
	public GetDataKeywords(String stringggg) {
		// TODO Auto-generated constructor stub
		System.out.println(stringggg);
//		SeleniumFunctions sfSelenium = new SeleniumFunctions(stringggg);
////		SeleniumFunctions sfSelenium = new SeleniumFunctions(stringggg);
////		//SeleniumFunctions sfSelenium = new SeleniumFunctions("chrome");
//	//	
////		// driver variable
//		WebDriver driver;
//	//	
//	//	
////		// Set URL
//	String pURL = "http://demo.guru99.com/V1/index.php";
	}



	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();	
	}
	
	

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
	
	
	
	// Click on Payment Gateway Link
	public void clickPaymentGateway() {
		sfSelenium.clickLink("Payment Gateway Project");
	}
	

	
	// select quantity
	public void selectQuantity(String pQuantity) throws IOException {
		sfSelenium.populateDropDown("quantity", pQuantity);
		
		// Capture a screenshot to extent reports
		sfSelenium.logScreenShot();
	}
	
	// click buy now
	public void clickBuyNow() {
		this.driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
	}
	
	// capture the payment details
	public void captureLoginDetails(String pLoginName, String pLoginPass) throws IOException {
		
		// Capture Login name
		sfSelenium.populateInputField(By.name("uid"), pLoginName);
		
		// Capture Login password
		sfSelenium.populateInputField(By.name("password"), pLoginPass);
		
		
		// Log a Screenshot to the report
		sfSelenium.logScreenShot();
		
		// Capture Payment Detail - Click Pay
		//driver.findElement(By.name("submit")).click();
	}
	
	// capture the payment details
	public void capturePaymentDetails(String pCardNumber, String pExpMonth, String pExpYear, String pCVV) throws IOException {
		// Capture Card Number
		sfSelenium.populateInputField(By.name("card_nmuber"), pCardNumber);
		
		// Capture Expiration Month
		sfSelenium.populateDropDown("month", pExpMonth);
		
		// Capture Expiration Year
		sfSelenium.populateDropDown("year", pExpYear);
		
		// Capture CVV Code
		sfSelenium.populateInputField(By.id("cvv_code"), pCVV);
		
		// Log a Screenshot to the report
		sfSelenium.logScreenShot();
		
		// Capture Payment Detail - Click Pay
		//driver.findElement(By.name("submit")).click();
	}
	
	public void clickPay( ) throws IOException {

		// Capture Payment Detail - Click Pay
		this.driver.findElement(By.name("submit")).click();
	}
	
	// Go to the card generate
	public void clickGenerateCardNumber() throws IOException {
		// navigate to url
		navigateToURL(pURL);
		// click buy now
		sfSelenium.clickLink("here");
		//take a screen shot
		sfSelenium.logScreenShot();
			
		}
	
//	// Get Detail
//	public String getDetail(String sCssOfField) throws IOException {
//		// get field text
//		String sFieldText = this.driver.findElement(By.cssSelector(sCssOfField)).getText();
//		// print but remove this later
//	    System.out.println("getDetail: " + sFieldText);
//	    // return
//		return sFieldText;
//	}
	
	
	public String getCreditCardDetail(int iChildField,int igetLastDigits) throws IOException {
		//// CSS for the field
		String cssOfField = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(" + iChildField + ")";
		//// Get the field value
		String sFieldValue = this.driver.findElement(By.cssSelector(cssOfField)).getText();
	    //// Get the last digits
		String sStrippedFieldValue = sfSelenium.getLastDigits(igetLastDigits, sFieldValue);
	    return sStrippedFieldValue;
	}
	   
	
	
	///// Run tests /////
	@BeforeTest
	public  void runTestStart () {
		// set the value for driver
		
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Demo", "Get data");
		sfSelenium.createTest("Start Test");
		
		
	}
	
	public void runTestAutoGeneratedData () throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test with autoGenerated data");
		// Input test Data
		String pQuantity = "2";
		String pCardNumber = "";
		String pExpMonth = "";
		String pExpYear = "";
		String pCVV = "";
		String pExpMonthYear = "";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		selectQuantity(pQuantity);
		
		clickBuyNow();
		
		clickGenerateCardNumber();
		//Get Credit Card Details
		// Switch to tab 1
		sfSelenium.switchTab(1);
		// Get Credit Card number
		pCardNumber = getCreditCardDetail(3,16);
		// Get Cvv number
		pCVV = getCreditCardDetail(4,3);
		// Get Month/Year 
		pExpMonthYear = getCreditCardDetail(5,7);
		// Get Year
		pExpYear = getCreditCardDetail(5,4);
		// Get Year
		pExpMonth = sfSelenium.getFirstDigits(2, pExpMonthYear);
		
		// Switch back to the original tab
		sfSelenium.switchTab(0);
	
		//CreditCardDetails();
		
		capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
		clickPay();
			
		Thread.sleep(5000);
		
		String tablexpath = "//table/tbody";
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));

		System.out.println("Total Number of cells/columns in the table are: "+TotalColsList.size());
		
		String firstCell = "//tbody/tr[1]/td[1]";
		System.out.println(driver.findElement(By.xpath(firstCell)).getText());
		

	}
	
	public void clickCheckCreditCardLimit() {
		sfSelenium.clickLink("Check Credit Card Limit");
	}
	
	public void captureEmail( String pEmailaddi) throws IOException {
		// Capture Card Number
		sfSelenium.populateInputField(By.name("emailid"), pEmailaddi);
	}
	
	public void captureDetails( String pCredNo) throws IOException {
		// Capture Card Number
		sfSelenium.populateInputField(By.name("card_nmuber"), pCredNo);
	}
	
	public void clickSubmit() {
		try {
			this.driver.findElement(By.xpath("//input[@value='submit']")).click();
		}	catch (Exception e){
				this.driver.findElement(By.xpath("//input[@value='Submit']")).click();
			}
	}
		

	
	public void runNewTestAlert() throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test: demo alerts");

		// Enter an invalid card number
		String pCardNumber = "5154";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		clickCheckCreditCardLimit();
		
		captureDetails(pCardNumber);
		
		clickSubmit();
		
		//clickGenerateCardNumber();
		
		//Create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		Thread.sleep(500);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		Thread.sleep(500);
	}
	
	public void runTestAlert () throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test: demo alerts");
		// Input test Data
		String pQuantity = "9";
		// Enter an invalid card number
		String pCardNumber = "134665";
		String pExpMonth = "06";
		String pExpYear = "2024";
		String pCVV = "333";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		selectQuantity(pQuantity);
		
		clickBuyNow();
		
		//clickGenerateCardNumber();
		
		capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
		clickPay();
		

		//Create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(this.driver,60);
		wait.until(ExpectedConditions.alertIsPresent());

		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		Thread.sleep(500);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		Thread.sleep(500);
		
		//sfSelenium.CloseSelenium();
	}
	
	public void runMyTestAlert () throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test: My Test alert");
		// Input test Data
		// Enter an invalid card number
		String pCardNumber = "5454";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		this.driver.findElement(By.linkText("Check Credit Card Limit")).click();		
		
		sfSelenium.switchTab(-1);
		
		sfSelenium.populateInputField(By.id("card_nmuber"), pCardNumber);
		
		this.driver.findElement(By.name("submit")).click();

		//Create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		Thread.sleep(500);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		Thread.sleep(500);
		
		//sfSelenium.CloseSelenium();
	}
	
	
	public void creditlimt() throws InterruptedException {
	
	String pBogusMessage = "sfdgsdfsdgf";
	String pExpectedMessage = "Check card number is 16 digits!";
	String pCardNumber="1234";
	navigateToURL(pURL);
	
	clickPaymentGateway();
	
  this.driver.findElement(By.linkText("Check Credit Card Limit")).click();	
  
  sfSelenium.populateInputField(By.id("card_nmuber"), pCardNumber);
  
 this.driver.findElement(By.name("submit")).click();
 
	Alert alert = this.driver.switchTo().alert();
	
	String sAlertMessage = alert.getText();
	System.out.println(sAlertMessage);
	
	Thread.sleep(500);
	alert.accept();
	sfSelenium.updateReport(sAlertMessage,pBogusMessage);
	sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
	
	Thread.sleep(500);
}
	
	
	public void runTestToolTip () throws IOException, InterruptedException {
		
		sfSelenium.createTest("Run Test: Tool tips");
		// Input test Data
		String pQuantity = "9";
		String pCardNumber = "";
		String pExpMonth = "";
		String pExpYear = "2024";
		String pCVV = "333";
		String pExpMonthYear = "";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		selectQuantity(pQuantity);
		
		clickBuyNow();
		
		clickGenerateCardNumber();
		
		
		clickPay();

		//Create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		//Thread.sleep(5000);
	}
	
	public void runTestReadFromFile () throws IOException, InterruptedException {

		// Input test Data
		String pLoginName = "";
		String pLoginPass = "";
		String pLoginExpecteResult = "";
		String csvdir = getProperties("logincsv"); 
		String sAlertMessage = "";
		
				
		BufferedReader br = new BufferedReader(new FileReader(csvdir)); 
		String line;
		
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
				sfSelenium.createTest("Reading Data");
		    // use xx as separator.
			    String[] cols = line.split(";"); 
			    pLoginName = cols[0];
			    pLoginPass = cols[1];
			    pLoginExpecteResult = cols[2];
			    
				navigateToURL(pURL);
				
				// Check if the it's a success case
			    boolean isSuccessCase = pLoginExpecteResult.equals("successful login");
			    
				
				captureLoginDetails(pLoginName, pLoginPass);
				this.driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
				
				if(isSuccessCase) {
					sfSelenium.createTest("Happy case");
					sfSelenium.doValidation("successful login",pLoginExpecteResult);
					this.driver.findElement(By.xpath("//img[1]"));
					sfSelenium.logScreenShot();
				} else {
					sfSelenium.createTest("Alert case");
					//Create an object of the alert
					WebDriverWait wait = new WebDriverWait(this.driver,60);
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alert = this.driver.switchTo().alert();
					sAlertMessage = alert.getText();
					sfSelenium.doValidation(sAlertMessage,pLoginExpecteResult);
					//sfSelenium.logScreenShot();
					//Thread.sleep(5000);
					// Handle alert
					// taking a screenshot accepted the alert
					alert.accept();
					
					//sfSelenium.logScreenShot();
				} 
			}
		    
		}	
		//  close the buffer
		br.close();
		
	}
	
	@Test
	public void runTestGetEmailData() throws IOException {
		int min = 1;
		int max = 10000;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println("randomNumber = " + randomNum);
		clickGenerateCardNumber();
		//generateDateTimeStamp in extent reports
		System.out.println();
		captureEmail(randomNum + "@randomdomain.com");
		clickSubmit();
		String pEmailaddress = sfSelenium.getDetail("body:nth-child(2) table:nth-child(10) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)");
		String pPassword = sfSelenium.getDetail("body:nth-child(2) table:nth-child(10) tbody:nth-child(1) tr:nth-child(5) > td:nth-child(2)");
	    //captureDetails(pEmailaddress, pPassword);
	    //validateMessage(pMessage);
	}
	
	@AfterTest
	public void cleanup () throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: clean up");
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		sfSelenium.CloseSelenium();
	}
	
}



