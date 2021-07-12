package Exam2021Code;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class ProductItemPage extends BasePage{
	
	public void enterQuantity(String pQuantity) {
		EnterText(By.xpath("/html//input[@id='quantity_wanted']"), pQuantity);
	}
	
	public void clickAddToCart() {
		clickElement(By.cssSelector(".add-to-cart-geewiz.btn.btn-primary"));
	}
}
