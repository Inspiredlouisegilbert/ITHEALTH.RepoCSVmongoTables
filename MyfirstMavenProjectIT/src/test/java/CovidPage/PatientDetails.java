package CovidPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.BasePage;

public class PatientDetails extends BasePage{
	
 
	public void clickMale() throws InterruptedException{
		
	
		WebElement maleClick = driver.findElement(By.cssSelector("form[name='screenForm'] > .male"));
		Actions act = new Actions(driver);
		Thread.sleep(400);
		act.moveToElement(maleClick).click().perform();

		
	}
	
	public void clickFemale() throws InterruptedException{
		
		WebElement maleClick = driver.findElement(By.cssSelector("form[name='screenForm'] > .male"));
		Actions act = new Actions(driver);
		Thread.sleep(400);
		act.moveToElement(maleClick).click().perform();

	}
	
	public int getAge() {
		return  Integer.parseInt(getElementText(By.cssSelector("div:nth-of-type(2) > .tooltip-inner")));
	}
	
	public void incAge() throws InterruptedException {
		clickElement(By.xpath("//button[@class='control control-plus']"));
	}
	
	public void decAge() throws InterruptedException {
		clickElement(By.xpath("//button[@class='control control-minus']"));
	}
	
	public void setAge(int pAge) throws InterruptedException {
		int age= getAge();
		
		while (age!=pAge) {
			if (age>pAge) {
				decAge();
				age= getAge();
			}
			if (age<pAge) {
				incAge();
				age= getAge();
			}
			//if (age==pAge) {
			//	break;
			//}
		}
	
		
	}
	
	public void clickNext() throws InterruptedException {
		clickElement(By.cssSelector(".btn.btn-next.btn-primary.hidden-print.ng-binding"));
	}
	
}
