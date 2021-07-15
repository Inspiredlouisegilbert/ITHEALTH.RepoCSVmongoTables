package Exam2021Code;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkclasses.ReadExcel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
public class ExamTestCase {
	HomePage home = new HomePage();
	ProductItemPage item= new ProductItemPage();
	SearchResultsPage results= new SearchResultsPage();
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider ="testData")
	public void ItemQuantityTest(String search, String sort, String quantity, String ItemNumber) {
		
//When  User enters search criteria in the text box
		home.EnterSearchItem(search);
//AND  User clicks on the magnifying glass button
		home.ClickSearch();
//AND  User makes a selection in the "Sort By" drop down list
		results.selectSortBy(sort);
//AND  User selects the first result
		results.waitTill(sort);
		results.selectItem(Integer.parseInt(ItemNumber));
//AND  User enters the quantity in the "Quantity" text field Quantity > 100 
	    item.enterQuantity(Integer.parseInt(quantity )+ 1);
		//item.getMaxQuantity(Integer.parseInt(quantity));
//AND  User clicks on the "Add to cart" button
		//item.clickAddToCart();
//THEN  User receives stock pop up message 
		String actual = item.stockPopUpMessage();
		item.handleErrorMessage();
		String expected = "We have only " +quantity + " of this item in stock. Your requested quantity has been automatically adjusted.";
		Reporter.log("expected ------------------"+expected);
        Reporter.log("actual --------------------"+actual);
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		/*
		 
		AND   User clicks on Continue shopping button
		
		*/	
		
	}
	
	@DataProvider(name = "testData")
	public  Object[][]  getDataFromExcel() throws IOException{
		return rExcel.excelDP("excelDataDir", "ExcelData.xlsx", "Sheet1");
	}
}
