package MvuyoAssignment;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkclasses.BasePage;

public class GuruHomePage extends BasePage {

	//instantiate driver
	WebDriver driver;
	
	String fname = "Mvuyo"; 
	String lname = "Mdekazi";
	String email = "majeke5445@gmail.com"; 
	String pAddress = "48 Thor Circle, Thornton"; 
	String pMobileNum = "073 864 1414";
	
	@Test
//Navigate to URL
  public void navigateToURL(String pURL) {
		driver.get(pURL);
		
	}
  
	@Test
  public void maximiseBrowserWindow() {
		driver.manage().window().maximize();
		 
	}
  
	@Test
  public void clickCustomer() {
	        driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")).click();
	    }
  
	@Test
  public void clickBackgroundCheckRadio() {
	  driver.findElement(By.xpath("//label[.='Done']")).click();
  }
  
	@Test
  public void fillFormDetailes(String fname, String lname, String email, String pAddress, String pMobileNum) {
		
  	driver.findElement(By.cssSelector("#fname")).sendKeys(fname);
  	driver.findElement(By.cssSelector("#lname")).sendKeys(lname);
  	driver.findElement(By.cssSelector("#email")).sendKeys(email);
  	driver.findElement(By.cssSelector("#message")).sendKeys(pAddress);
	driver.findElement(By.id("#telephoneno")).sendKeys(pMobileNum);

  }
  
	@Test
  public void clickSubmitButton() {
	  driver.findElement(By.xpath("//input[@name='submit']")).click();
  }
}