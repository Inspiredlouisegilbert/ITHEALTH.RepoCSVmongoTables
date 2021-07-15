package Exam2021Code;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class ProductItemPage extends BasePage {
	
	public void enterQuantity(int pQuantity) {
		getElement(By.xpath("/html//input[@id='quantity_wanted']")).clear();
		EnterText(By.xpath("/html//input[@id='quantity_wanted']"),Integer.toString(pQuantity));
	}
	
	public void getMaxQuantity(int pOption){
		boolean max= true;
		while(max) {
			
			try {
				enterQuantity(pOption);
				System.out.println("entered value ");
				String message = stockPopUpMessage();
				//System.out.println(message);
				max = false;
			}catch (Exception e) {
				pOption = pOption+100;
				System.out.println("added 100");			
				}
				
			}
		}
	
	  public void handleErrorMessage() {
      	clickElement(By.xpath("//*[@id=\"product_confirmation_modal\"]/div[2]/button"));
      }
	
	public void clickAddToCart() {
		clickElement(By.cssSelector(".add-to-cart-geewiz.btn.btn-primary"));
		
	}
	
	public String getMaxNum() {
		return getElementText(By.xpath("/html//input[@id='quantity_wanted']"));
	}
	
	public String stockPopUpMessage() {
		return getElementText(By.xpath("//*[@id='product_confirmation_modal']/div[1]"));
	}
	
	public boolean isPopUpVisisible() {
		return getElement(By.xpath("//*[@id='product_confirmation_modal']/div[1]")).isDisplayed();
}
	}
