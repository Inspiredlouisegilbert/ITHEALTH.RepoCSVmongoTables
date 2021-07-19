package mvuyoExam;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import frameworkclasses.BasePage;

public class ProductPage extends BasePage {

	public void SearchDell(String pBrand) {
		clickJavascript(By.xpath("//*[contains(text(),'"+pBrand+"')]"));
	}
	
	public void waitFunction(String pProduct){
		  waitForUrl(10,pProduct);
	}
	
	public void SelectDellProduct(){
		clickJavascript(By.xpath("//*[@id=\"js-product-list\"]/div/div/div/div[1]/article/div/div[2]/h3/a"));
	}
	
	public void RateProduct() {
		clickJavascript(By.xpath("/html//a[@id='bt_btn-review-form']"));
	}
	
	public String ValidateMessage() {
		return getElementText(By.xpath("//div[contains(text(),'You cannot post a review because you are either no')]"));
	}
	
	public void ClosePopUpMessage() {
		clickJavascript(By.xpath("//body[@id='product']/div[18]/div//a[@title='Close']"));
	}
	
	public void AddToCart() {
		clickJavascript(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]"));
	}
	
}
