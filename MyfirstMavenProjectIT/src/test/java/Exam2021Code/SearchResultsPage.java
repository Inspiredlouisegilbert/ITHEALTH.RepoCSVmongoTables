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
        
        public void waitTill() {
        	WebDriverWait wait = new WebDriverWait(BasePage.driver,10);
        	wait.until(ExpectedConditions.urlContains("https://www.geewiz.co.za/search?controller=search&s=solar&order=product.price.asc"));
        }
}
