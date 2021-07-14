package PolelaExam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class BrandPage extends BasePage {
	public void selectBrand(String pBrand) {
		clickElement(By.xpath("//*[contains(text(),'"+pBrand+"')]"));
	}
	
	public void selectProduct() {
		clickElement(By.xpath("//*[@id=\"js-product-list\"]/div/div/div/div[1]/article/div/div[2]/h3/a"));
	}
	
	
	public void waitFunction(){
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
}
