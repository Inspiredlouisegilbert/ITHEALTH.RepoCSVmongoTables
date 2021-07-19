package PolelaExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class ProductPage extends BasePage
{

	 public void rateProduct() {
		 clickJavascript(By.xpath("/html//a[@id='bt_btn-review-form']"));
	 }
	 
	 public void clickContinue() {
		 clickJavascript(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content-btn']/button[@type='button']"));
	 }
	 
	 public String getErrorMessage() {
		 return getElementText(By.xpath("/html//body[@id='product']/div[18]/div//div[@id='gsr']"));
	 }
	 
	 public void clickClose() {
		 clickJavascript(By.xpath("//body[@id='product']/div[18]/div//a[@title='Close']"));
	 }
	 
	 public void clickAddToCart() {
		 clickJavascript(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div[1]/div[2]/button[1]"));
	 }
}
