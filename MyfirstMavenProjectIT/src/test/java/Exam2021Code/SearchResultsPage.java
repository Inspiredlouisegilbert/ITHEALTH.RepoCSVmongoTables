package Exam2021Code;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.BasePage;

public class SearchResultsPage extends BasePage {
        public void selectSortBy(String pOption) {
        	clickElement(By.cssSelector(".btn-unstyle.select-title"));
        	clickElement(By.partialLinkText(pOption));
        }
        
        public void selectItem(int pOption) {
        	
        	clickElement(By.xpath("//*[@id='js-product-list']/div/div/div/div["+pOption+"]"));
        }
        
        public void waitTill(String pSort) {
        	WebDriverWait wait = new WebDriverWait(BasePage.driver,10);
        	switch (pSort) {
			case "Relevance":
	        	wait.until(ExpectedConditions.urlContains("product.position.desc"));
				break;
			case "Name, Z to A":
	        	wait.until(ExpectedConditions.urlContains("product.name.desc"));
				break;
			case "Name,  A to Z":
				wait.until(ExpectedConditions.urlContains("product.name.asc"));
				break;
			case "PRICE, LOW TO HIGH":
				wait.until(ExpectedConditions.urlContains("product.price.asc"));
				break;
			
			case "PRICE, HIGH TO LOW":
	        	wait.until(ExpectedConditions.urlContains("product.price.desc"));

				break;
        	}
        }
        
      
}
