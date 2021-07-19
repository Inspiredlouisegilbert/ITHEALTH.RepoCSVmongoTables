package FaithExam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkclasses.ReadExcel;

public class ExamTestScript {

	
	HomePage home = new HomePage();
	ItemBrandPage item = new ItemBrandPage();
	BargainItemPage prod = new BargainItemPage();
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider = "testData",priority = 0)
	public void TestExam(String pitem) {
//WHEN  User search for an item by clicking the link "Bargain Item Bin"
	home.clickBargainItem();
//AND   User select the "dell" check box option
	item.selectItemBrand(pitem);
	item.waitFunction(pitem);
//AND   User clicks on the first item displayed 
	item.selectItem();
//THEN  User verifies the rate pop message
	prod.rateItem();
//AND   User asserts the rate pop up message "You cannot post a review because you are either not logged in or you have not purchased this product
	String Actual = prod.getItemError();
	String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
	Assert.assertEquals(Actual, Expected);
	prod.clickClose();
	prod.clickAddToCartItem();
	prod.clickContinueBtn();
	}
	
	@DataProvider (name = "testData")
	public  Object[][]  getDataFromExcel() throws IOException{
		return rExcel.excelDP("excelDataDir", "FaithExcelData.xlsx", "Sheet1");
	}
	
}
