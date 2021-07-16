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

	@Test (priority=0)
	public void StartTestExam() {
//WHEN  User search for an item by clicking the link "Bargain Item Bin"
	home.clickBargainItem();
//AND   User select the "dell" check box option
	item.selectItemBrand("Dell");
	item.waitFunction("Dell");
	}
	@Test(priority = 1)
	public void EnterSearchItem () {
//AND   User clicks on the first item displayed 
	item.selectItem();
//THEN  User verifies the rate pop message
	prod.rateItem();
//AND   User asserts the rate pop up message "You cannot post a review because you are either not logged in or you have not purchased this product
	String Actual = prod.getItemError();
	String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
	Assert.assertEquals(Actual, Expected);

	}
	@Test (priority =2)
	public void FinalOutcomes() {
	prod.clickClose();
	prod.clickAddToCartItem();
	}
	//@DataProvider(name = "testData")
	@Test (priority =3)
	public  Object[][]  getDataFromExcel() throws IOException{
		return rExcel.excelDP("excelDataDir", "FaithExcelData.xlsx", "Sheet1");
	}
	
}
