package PolelaExam;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript {


	HomePage home = new HomePage();
	BrandPage brand = new BrandPage();
	ProductPage prod = new ProductPage();
	
	@Test (priority=0)
	public void StartTest() {
	brand.selectBrand("Dell");
	brand.waitFunction("Dell");
	}

	@Test(priority = 1)
	public void EnterSearch () {

	brand.selectProduct();
	prod.rateProduct();
	String Actual = prod.getErrorMessage();
	String Expected = "You cannot post a review because you are either not logged in or you have not purchased this product";
	Assert.assertEquals(Actual, Expected);

	}
	@Test (priority =2)
	public void Results() {
	prod.clickClose();
	prod.clickAddToCart();
	}
	
	
	
}
