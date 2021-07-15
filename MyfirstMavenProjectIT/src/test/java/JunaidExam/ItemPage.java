package JunaidExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class ItemPage extends BasePage{
	
	public void clickRateProduct() {
		clickJavascript(By.xpath("/html//a[@id='bt_btn-review-form']"));
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
	 
	 public void proceedToShop() {
		 clickJavascript(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div[2]/button"));
	 }
}
