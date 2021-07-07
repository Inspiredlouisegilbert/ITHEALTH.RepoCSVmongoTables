package com.org.MyFristMavenProjectIT;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class TablesDemoKeywords extends BasePage{
	
	
	String pURL = "http://demo.guru99.com/test/table.html";

	///// Run tests /////
	
	@BeforeTest
	public void runTestStart () {
		driver.get(pURL);
	}
	
	@Test
	public void tabless() throws IOException {
		String tablexpath = "//table/tbody";
		// Look at rows
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		// Look at cells
		WebElement ToGetCells = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalCells = ToGetCells.findElements(By.tagName("td"));
		System.out.println("Total Number cells: "+TotalCells.size());
		
		// Look at columns
		WebElement ToGetColumns = driver.findElement(By.xpath("//tbody/tr[3]"));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
		System.out.println("Total Number of colums in row 1: "+TotalColsList.size());
		
		// Look at field values
		WebElement ToGetFieldValues = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
		System.out.println("Field value for row 1 column 1: "+ ToGetFieldValues.getText());	
	}
	   
	@AfterTest
	public void cleanup () throws IOException, InterruptedException {
		driver.close();
	}

}



