package MvuyoAssignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import MvuyoAssignment.AddCustomer;
import MvuyoAssignment.GuruHomePage;
import pages.LandingPage;
import pages.ProductSearchPage;
import pages.SignInPage;

public class RunAssignment {
 

  GuruHomePage home = new GuruHomePage();
  AddCustomer addCustomer = new AddCustomer();
  
  @Test(priority = 0)
  public void testHeader1() {
      home.clickCustomer();
      String ActualHeading = home.getheader(By.xpath("//span[@id='header']//a[@href='index.html']"));
      String ExpectedHeading = "Guru99 telecom";
      addCustomer.clickDone();



      
       Reporter.log("expected result:"+ExpectedHeading);
          Reporter.log("actual result:"+ActualHeading);
          Assert.assertEquals(ActualHeading, ExpectedHeading ); 



  }
  
  @Test(priority = 1)
  public void testHeader() {
//      addCustomer.clickDone();
      String ActualHeader2= addCustomer.getheader(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']"));
      String Expectedh2= "Add Customer";
      
      
       Reporter.log("expected result:"+Expectedh2);
          Reporter.log("actual result:"+ActualHeader2);
          Assert.assertEquals(ActualHeader2, Expectedh2); 



  }
  
  @Test(priority = 2)
  public void testlabel() {
      addCustomer.filldata("mvuyo"," mdekazi", "majeke5445@gmail.com", "this is dummy text!!*", "0738641414");
      String Actuallabel= addCustomer.getMessage();
      
      String Expectedlabel = "Special characters are not allowed";
      
       Reporter.log("expected result:"+Expectedlabel);
          Reporter.log("actual result:"+Actuallabel);
          Assert.assertEquals(Actuallabel, Expectedlabel); 



  }
  
  @Test(priority = 3)
  public void testAlert() {
      String ActualAlert= addCustomer.getAlert();
      
      String ExpectedAlert = "please fill all fields";



       Reporter.log("expected:"+ExpectedAlert);
          Reporter.log("actual result:"+ActualAlert);
          Assert.assertEquals(ActualAlert, ExpectedAlert); 



  }
  
  
}

