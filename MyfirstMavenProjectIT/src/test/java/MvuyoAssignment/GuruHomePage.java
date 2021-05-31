package MvuyoAssignment;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkclasses.BasePage;

public class GuruHomePage extends BasePage {

	//instantiate driver
	WebDriver driver;
	String pURL = "http://demo.guru99.com/telecom/index.html";
  @Test
//Navigate to URL
  public void navigateToURL(String pURL) {
		driver.get(pURL);

	}
  
  public void maximiseBrowserWindow() {
		driver.manage().window().maximize();
	}
  
  public void clickCustomerLink() {
	  driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")).click();
  }
  
  public void clickBackgroundCheckRadio() {
	  driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")).click();
  }
}