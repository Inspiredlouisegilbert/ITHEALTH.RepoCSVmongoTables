package Exam2021Code;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class SearchResultsPage extends BasePage {
        public void selectSortBy(String pOption) {
        	clickElement(By.cssSelector(".btn-unstyle.select-title"));
        	clickElement(By.partialLinkText(pOption));
        }
        
        public void selectItem(int pOption) {
        	clickElement(By.xpath("//*[@id='js-product-list']/div/div/div/div["+pOption+"]"));
        }
}
