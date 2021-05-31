package TelcoProject;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class Assignment1 {

	TelcoHomePage home = new TelcoHomePage();
	
	AddCustomer customer = new AddCustomer();
	
	
public void testHeader() {
	home.clickAddCustomer();
	String ActualHeader1=customer.getHeader1(By.xpath("//span[@id= 'header']//a[@href='index.html']"));
	String ExpectedHeader1="Guru 99 Telcom";
	customer.clickDoneBtn();
	
	Reporter.log("expected---------------------------"+ExpectedHeader1);
	Reporter.log("actual----------------------------"+ActualHeader1);
	Assert.assertEquals(ActualHeader1, ExpectedHeader1);
}

	
	
	
}
