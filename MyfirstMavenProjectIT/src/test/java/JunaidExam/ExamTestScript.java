package JunaidExam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkclasses.ReadExcel;

public class ExamTestScript {
	HomePage home = new HomePage();
	BarginBinPage bargin = new BarginBinPage();
	ItemPage item = new ItemPage();
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider = "testData" )
	public void RateItTest(String pBrand) {
		//Click on Bargin Bin Link
		home.clickBargain();
		//Select a Brand
		bargin.clickBrand(pBrand);
		bargin.waitToLoad(pBrand);
		//Click the First Item
		bargin.clickProduct(1);
		//Click the Rate It button
		item.clickRateProduct();
		//Assert Error message to equal You cannot post a review because you are either not logged in or you have not purchased this product 
		String Actual = item.getErrorMessage();
		String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
		Assert.assertEquals(Actual, Expected);
		
		item.clickClose();
		item.clickAddToCart();
		item.proceedToShop();
	}
	
	@DataProvider(name = "testData")
	public  Object[][]  getDataFromExcel() throws IOException{
		return rExcel.excelDP("excelDataDir", "ExcelData.xlsx", "Sheet1");
	}
}
