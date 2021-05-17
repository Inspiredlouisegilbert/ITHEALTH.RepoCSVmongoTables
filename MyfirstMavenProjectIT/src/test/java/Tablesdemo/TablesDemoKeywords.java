package Tablesdemo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import frameworkclasses.SeleniumFunctions;

public class TablesDemoKeywords {
	
	// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("chrome");
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	WriteTableData sTableData = new WriteTableData();
	
	//String pURL = "http://demo.guru99.com/test/table.html";
	String pURL = "http://demo.guru99.com/test/web-table-element.php";
	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	
	
	///// Run tests /////
	
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Payment Gateway Project", "Playing with tables");
		sfSelenium.createTest("Start Test");
	}
	
	public void tabless() throws IOException, InterruptedException {
		
		sfSelenium.createTest("Run Test: Tables");
		navigateToURL(pURL);
		String tablexpath = "//table/tbody";
		// Look at rows
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		// Look at columns

				WebElement ToGetColumns = driver.findElement(By.xpath("//tbody/tr[3]"));
				List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
				System.out.println("Total Number of colums in row 1: "+TotalColsList.size());
				WebElement ColumnHeader = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[5]"));
		System.out.println("Column name is: "+ ColumnHeader.getText() );
		//*[@id="leftcontainer"]/table/thead/tr/th[5]
		//tbody/tr/th[5]
		int count = 0;
		for (int i = 0; i < TotalRowsList.size()-1; i++) {
			count++;

		
		// Look at field values
		WebElement ToGetFieldValues = driver.findElement(By.xpath("//tbody/tr["+count+"]/td[5]"));
		//System.out.println("Field value for row 1 column 1: "+ ToGetFieldValues.getText());
		//System.out.println("The value of the column is: " + ToGetFieldValues.getText());
		float f=Float.parseFloat(ToGetFieldValues.getText().substring(2));
		String sLine = "";
		if ( f > 4 ) {
			for (int j = 1; j <= TotalColsList.size();j++) {
				WebElement WriteToFile = driver.findElement(By.xpath("//tbody/tr["+count+"]/td["+j+"]"));
				sLine += WriteToFile.getText() + " ";
		}
			System.out.println("The value of the columns  that are greater than 4 are: " + sLine);
			sTableData.writeToFile(sLine);

		}
		}
		//Assert.assertEquals(expected, actual)
		
		sfSelenium.logScreenShot();	
	}


	public void cleanup () throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: clean up");
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		sfSelenium.CloseSelenium();	
		//
	}

	
}



