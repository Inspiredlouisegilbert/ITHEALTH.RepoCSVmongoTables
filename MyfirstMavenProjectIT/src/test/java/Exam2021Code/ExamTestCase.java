package Exam2021Code;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
public class ExamTestCase {
	HomePage home = new HomePage();
	ProductItemPage item= new ProductItemPage();
	SearchResultsPage results= new SearchResultsPage();
	
	@Test
	public void ItemQuantityTest() {
		
//When  User enters search criteria in the text box
		home.EnterSearchItem("solar");
//AND  User clicks on the magnifying glass button
		home.ClickSearch();
//AND  User makes a selection in the "Sort By" drop down list
		results.selectSortBy("PRICE, LOW TO HIGH");
//AND  User selects the first result
		results.waitTill();
		results.selectItem(2);
//AND  User enters the quantity in the "Quantity" text field Quantity > 100 
	  //  item.enterQuantity(800);
		item.getMaxQuantity(101);
//AND  User clicks on the "Add to cart" button
		//item.clickAddToCart();
//THEN  User receives stock pop up message 
		String actual = item.stockPopUpMessage();
		String expected = "We have only 765 of this item in stock. Your requested quantity has been automatically adjusted.";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		/*
		 
		AND   User clicks on Continue shopping button
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
