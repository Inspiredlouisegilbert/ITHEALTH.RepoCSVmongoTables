package JunaidExam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkclasses.ReadExcel;

public class ExamTestScript {
	//the test fail intermittently due to website errors
	HomePage home = new HomePage();
	BarginBinPage bargin = new BarginBinPage();
	ItemPage item = new ItemPage();
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider = "examData")
	public void RateItTest(String pBrand) {
		
		if (pBrand == null) {
			Reporter.log("value given is null");
			throw new SkipException("value given is null");
		}
		else {
		//Click on Bargin Bin Link
		home.clickBargain();
		Reporter.log("Clicked on Bargin Bin Link");
		
		//Select a Brand
		bargin.clickBrand(pBrand);
		bargin.waitToLoad(pBrand);
		Reporter.log("Clicked Brand filter");

		//Click the First Item
		bargin.clickProduct(1);
		Reporter.log("Clicked on first product");

		//Click the Rate It button
		item.clickRateProduct();
		Reporter.log("Clicked on rate it button");
		
		//Assert message to equal You cannot post a review because you are either not logged in or you have not purchased this product 
		String Actual = item.getErrorMessage();
		String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
		if (Actual == Expected) {
			Reporter.log("Test Passed");
			Reporter.log("expected ------------------"+Expected);
	        Reporter.log("actual --------------------"+Actual);
		}
		else {
			Reporter.log("Test Passed");
			Reporter.log("expected ------------------"+Expected);
	        Reporter.log("actual --------------------"+Actual);
		}
		Assert.assertEquals(Actual, Expected);
		
//		Handle message
		item.clickClose();
		
//		CLick add to cart
		item.clickAddToCart();
		Reporter.log("Clicked Add to Cart");

//		Click Proceed to shop
//		item.proceedToShop();
//		Reporter.log("Clicked Proceed to Shop");

		}
	}
	
	@DataProvider(name = "examData")
	public  Object[][]  getDataFromExcel() throws IOException{
		//return rExcel.excelDP("excelDataDir", "ExcelData.xlsx", "Sheet1");
		String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
		Object[][] arrObj = rExcel.getExcelData(excelDirectory+"ExcelData.xlsx", "Sheet1");

        return arrObj;
	}
}
