package PolelaExam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkclasses.ReadExcel;

public class TestScript {


	HomePage home = new HomePage();
	BrandPage brand = new BrandPage();
	ProductPage prod = new ProductPage();
	ReadExcel rExcel = new ReadExcel();
	

	@Test(dataProvider = "testData",priority = 0)

	public void TestExam(String pbrand) {
	//When  User under the filter by option
	home.clickBargain();
	
	//AND User selects Dell checkbox option
	brand.selectBrand(pbrand);
	
	brand.waitFunction(pbrand);
	
	//AND   User clicks on the first item displayed 
	brand.selectProduct();
	
	prod.rateProduct();
	//THEN  User validates the rate pop message
	String Actual = prod.getErrorMessage();
	
	String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
	
	prod.clickClose();
	//AND   User adds the item to the cart button
	prod.clickAddToCart();
	prod.clickContinue();
	
	//THEN  User handles the stock pop up message
	Assert.assertEquals(Actual, Expected);
	}
//	@Test(priority = 1)
//	public void EnterSearch () {
//
//	brand.selectProduct();
//	prod.rateProduct();
//	String Actual = prod.getErrorMessage();
//	String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
//	Assert.assertEquals(Actual, Expected);
//
//	}
//	@Test (priority =2)
//	public void Results() {
//	prod.clickClose();
//	prod.clickAddToCart();
//	}
	@DataProvider(name = "testData")
	public  Object[][]  getDataFromExcel() throws IOException{
		return rExcel.excelDP("excelDataDir", "GeewizProducts.xlsx", "Sheet1");
	}
	
	
}
