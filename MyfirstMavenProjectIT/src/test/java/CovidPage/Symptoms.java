package CovidPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import frameworkclasses.BasePage;

public class Symptoms extends BasePage {

	public void clickCheckbox(String pId) throws InterruptedException {
		clickElement(By.xpath("//label [@for ='"+pId+"']"));
	}

	public void clickYesNoRadio(int pOption, String pAnswer) throws InterruptedException {
		if (pOption == 1) {
			if (pAnswer == "yes") {
				clickElement(By.cssSelector("[for='choice_s_0_present']"));
			}
			if (pAnswer == "no") {
				clickElement(By.cssSelector("[for='choice_s_0_absent]"));
			}
		}
		if (pOption == 2) {
			
				if (pAnswer == "yes") {
					clickElement(By.cssSelector("[for='choice_s_1_present']"));
				}
				if (pAnswer == "no") {
					clickElement(By.cssSelector("[for='choice_s_1_absent]"));
				}
			}
		
		if (pOption == 3) {
			
				if (pAnswer == "yes") {
					clickElement(By.cssSelector("[for='choice_s_2_present']"));
				}
				if (pAnswer == "no") {
					clickElement(By.cssSelector("[for='choice_s_2_absent]"));
				}
			}
		}


	
//	public boolean isButtonEnable(By pLocator) {
//		//change null to checkbox locator
//		clickCheckbox(null);
//		//pLocator should be for the button
//		return driver.findElement(pLocator).isEnabled();
//	}
	public void selectTempRadio(String pId) throws InterruptedException {
		clickElement(By.cssSelector(pId));
	}

	public void clickNoButton() throws InterruptedException {
		clickElement(By.xpath("//button[@class='btn-answer btn-answer-no ng-binding']"));
	}
	
	public void clickYesButton() throws InterruptedException {
		clickElement(By.xpath("//button[@class='btn-answer btn-answer-yes ng-binding']"));
	}
	
	public void clickNext() throws InterruptedException {
		//clickElement(By.cssSelector(".btn.btn-next.btn-primary.hidden-print.ng-binding"));
		driver.findElement(By.cssSelector(".status")).click();
		WebElement clickElement = driver.findElement(By.cssSelector(".btn.btn-next.btn-primary.hidden-print.ng-binding"));
		Actions act = new Actions(driver);
		Thread.sleep(100);
		act.moveToElement(clickElement).click().perform();
	
	}
}
