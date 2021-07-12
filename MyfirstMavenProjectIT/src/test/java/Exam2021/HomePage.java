package Exam2021;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class HomePage extends BasePage {
	
	public void EnterSearchItem(String pItem) {
		EnterText(By.xpath("//*[@id='search_widget']/form/input[2]"), pItem);
	}
	
	public void ClickSearch() {
		clickElement(By.xpath("//*[@id='search_widget']/form/button"));
	}

}
