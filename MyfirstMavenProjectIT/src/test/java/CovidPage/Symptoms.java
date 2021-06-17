package CovidPage;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class Symptoms extends BasePage {

	public void clickCheckbox(String pId) {
		clickElement(By.xpath("//label [@for ='"+pId+"'"));
	}

	public void clickYesNoRadio(int pOption, String pAnswer) {
		if (pOption == 1) {
			if (pAnswer == "yes") {
				clickElement(By.id("choice_s_0_present"));
			}
			if (pAnswer == "no") {
				clickElement(By.id("choice_s_0_absent"));
			}
		}
		if (pOption == 2) {
			
				if (pAnswer == "yes") {
					clickElement(By.id("choice_s_1_present"));
				}
				if (pAnswer == "no") {
					clickElement(By.id("choice_s_1_absent"));
				}
			}
		
		if (pOption == 3) {
			
				if (pAnswer == "yes") {
					clickElement(By.id("choice_s_2_present"));
				}
				if (pAnswer == "no") {
					clickElement(By.id("choice_s_2_absent"));
				}
			}
		}


	
//	public boolean isButtonEnable(By pLocator) {
//		//change null to checkbox locator
//		clickCheckbox(null);
//		//pLocator should be for the button
//		return driver.findElement(pLocator).isEnabled();
//	}
	public void selectTempRadio(String pId) {
		clickElement(By.id(pId));
	}

	public void clickNoButton() {
		clickElement(By.xpath("//button[@class='btn-answer btn-answer-no ng-binding']"));
	}
	
	public void clickYesButton() {
		clickElement(By.xpath("//button[@class='btn-answer btn-answer-yes ng-binding']"));
	}
	
	public void clickNext() {
		clickElement(By.cssSelector(".btn.btn-next.btn-primary.hidden-print.ng-binding"));
	}
}
