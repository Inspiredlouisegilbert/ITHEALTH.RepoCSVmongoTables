package PolelaExam;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript {

	HomePage home = new HomePage();
	BrandPage brand = new BrandPage();
	ProductPage prod = new ProductPage();
	
	@Test
	public void EnterSearch () {
		
	home.clickBargain();
	brand.selectBrand("dell");
	
	brand.selectProduct();
	prod.rateProduct();
	String Actual = prod.getErrorMessage();
	String Expected = "";
	
	Assert.assertEquals(Actual, Expected);
	
	prod.clickClose();
	
	prod.clickAddToCart();
	}
	
	
	
}
