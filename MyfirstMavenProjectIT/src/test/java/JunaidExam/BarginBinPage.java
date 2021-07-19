package JunaidExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class BarginBinPage extends BasePage {
	public void clickBrand(String pBrand) {
		clickJavascript(By.xpath("//*[contains(text(),'"+pBrand+"')]"));
	}
	
	public void clickProduct(int pItemNumber) {
		clickJavascript(By.xpath("//*[@id=\"js-product-list\"]/div/div/div/div["+pItemNumber+"]/article/div/div[2]/h3/a"));
	}
	
	
	public void waitToLoad(String pProduct){
	  waitForUrl(10, pProduct);
	}

}
