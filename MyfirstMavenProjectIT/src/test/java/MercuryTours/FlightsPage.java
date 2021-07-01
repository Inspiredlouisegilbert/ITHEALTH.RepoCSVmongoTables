package MercuryTours;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class FlightsPage extends BasePage {

	public  void CaptureFlightDetails(String pTripType,String sPassCount, String sFromPort, String sFromMonth, String sFromDay, String sToPort, String sToMonth, String sToDay, 
			String sPrefAirline, String sFlightType) {
		
		clickElement(By.xpath("//input [@name = '"+pTripType+"']"));
		// Flight Type		
		// Passengers dropdown/Select
		// Find our dropdown and stored it in a variable
		
		selectDropDown(By.xpath("//select[@name='passCount']"), sPassCount);
//select[@name='passCount']
		// From Port Drop Down
		
		selectDropDown(By.xpath("//select[@name='fromPort']"), sFromPort);
				
		// From Month Drop Down
		selectDropDown(By.xpath("//select[@name='fromMonth']"), sFromMonth);
		
		// From Day Drop Down
		selectDropDown(By.xpath("//select[@name='fromDay']"), sFromDay);
		
		// To Port Drop Down
		selectDropDown(By.xpath("//select[@name='toPort']"), sToPort);

		// To Month Drop Down
		selectDropDown(By.xpath("//select[@name='toMonth']"), sToMonth);
	
		// To Day Drop Down
		selectDropDown(By.xpath("//select[@name='toDay']"), sToDay);
		
		// Preffered Airline Drop Down
		selectDropDown(By.xpath("//select[@name='airline']"), sPrefAirline);
		
		// Service class
//		driver.findElement(By.xpath("//input[@value='First']")).click();
		// Multiple attributes
		clickElement(By.xpath("//input[@name='servClass'][@value=" + sFlightType + "]"));
		
	
		
		// Click Continue
		clickElement(By.xpath("//input[@name='findFlights']"));

	}
}
