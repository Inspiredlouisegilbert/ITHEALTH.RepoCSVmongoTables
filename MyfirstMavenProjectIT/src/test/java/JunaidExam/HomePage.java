package JunaidExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class HomePage extends BasePage {

	public void clickBargain() {
		clickElement(By.xpath("//*[@id=\"memgamenu-form_2830709306\"]/nav/div[2]/ul/li[4]/a"));
	}
	
}