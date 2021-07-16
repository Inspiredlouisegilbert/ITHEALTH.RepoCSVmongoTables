package FaithExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class ItemBrandPage extends BasePage{
	
	
	public void waitFunction(String pItem){
		  waitForUrl(10,"https://www.geewiz.co.za/1938-bargain-bin?q=Brand-"+ pItem);
		}
	
	public void selectItemBrand(String pItem) {
		clickElement(By.xpath("//*[contains(text(),'"+pItem+"')]"));
	}
	
	public void selectItem() {
		clickJavascript(By.xpath("//*[@id=\"js-product-list\"]/div/div/div/div[1]/article/div/div[2]/h3/a"));
		
	}
	
}
