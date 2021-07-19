package mvuyoExam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkclasses.ReadExcel;

public class TestCases {
	ProductPage pp = new ProductPage();
	HomePage hp = new HomePage();
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider ="testData")
	public void StartTestCase(String pBrand) {
		hp.clickBargainBin();
		//pp.waitFunction("Dell");
		pp.SearchDell(pBrand);
		pp.waitFunction(pBrand);
		pp.SelectDellProduct();
		pp.RateProduct();
		
		String actual = pp.ValidateMessage();
		String expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
		Assert.assertEquals(actual, expected);
		//report
		Reporter.log("expected ------------------"+expected);
        Reporter.log("actual --------------------"+actual);
		
		pp.ClosePopUpMessage();
		pp.AddToCart();
	}
	
	@DataProvider(name = "testData")
	public  Object[][]  getDataFromExcel() throws IOException{
		return rExcel.excelDP("excelDataDir", "ExcelData.xlsx", "Sheet1");
	}
}
