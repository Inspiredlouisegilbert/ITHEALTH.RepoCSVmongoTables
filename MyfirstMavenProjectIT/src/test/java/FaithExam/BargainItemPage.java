package FaithExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class BargainItemPage extends BasePage{

	
	 public void rateItem() {
		 clickJavascript(By.xpath("/html//a[@id='bt_btn-review-form']"));
	 }
	 
	 public String getItemError() {
		 return getElementText(By.xpath("/html//body[@id='product']/div[18]/div//div[@id='gsr']"));
	 }
	 public void clickAddToCartItem() {
	 clickJavascript(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div[1]/div[2]/button[1]"));
	 }
	 
	 public void clickContinueBtn() {
		 clickJavascript(By.xpath("//div[@class='cart-content-btn']/button[@type='button']"));
	
	 }
	 
	 public void clickClose() {
		 clickJavascript(By.xpath("//body[@id='product']/div[18]/div//a[@title='Close']"));
	
	 }
}
