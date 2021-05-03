package readFromPDF;

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
import org.pdfbox.pdmodel.PDDocument;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;


public class ReadFromPDF {
	//String pURL = "http://demo.guru99.com/V1/index.php";
	//String pURL = "c:\\Users\\LGilbert\\Dropbox (Old)\\My PC (ITLC3ML593)\\Downloads\\UntitledDocument.pdf";
	//C:\Users\LGilbert\Dropbox (Old)\My PC (ITLC3ML593)\Downloads
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("chrome");
	
	// driver variable
	WebDriver driver;
	


	// Get PDF content
	public String getPDFContent() throws Exception {
		String pdfurl = "c:\\Users\\LGilbert\\Dropbox (Old)\\My PC (ITLC3ML593)\\Downloads\\UntitledDocument.pdf";
        int expectedNoPages = 1;
        
        this.driver.get(pdfurl);
        String pdfContent = sfSelenium.readPDFContent(this.driver.getCurrentUrl(), expectedNoPages);
        //System.out.println(pdfContent);
        return pdfContent;
        
    }
	
	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	
	@Test
	public void testLookForTextInPDF() throws Exception {
		
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
		Assert.assertTrue(returnpdfContent.contains("LOUISE"));
	}
	
	@Test
	public void testEnsurePDFdoesNotContain() throws Exception {
		
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
        Assert.assertFalse(returnpdfContent.contains("Vukile"));
	}
	
	@Test
	public void expectedToFail() throws Exception {
		
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
        Assert.assertTrue(returnpdfContent.contains("Louise"));
	}
	
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}

}