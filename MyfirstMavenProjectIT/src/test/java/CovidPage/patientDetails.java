package CovidPage;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class patientDetails extends BasePage{
	
 
	public void clickMale(){
		clickElement(By.xpath("//label[1]"));
	}
	
	public void clickFemale(){
		clickElement(By.xpath("//label[2]"));
	}
	
	public int getAge() {
		return  Integer.parseInt(getElementText(By.cssSelector("div:nth-of-type(2) > .tooltip-inner")));
	}
	
	public void incAge() {
		clickElement(By.xpath("//button[@class='control control-plus']"));
	}
	
	public void decAge() {
		clickElement(By.xpath("//button[@class='control control-minus']"));
	}
	
	public void setAge(int pAge) {
		int age= getAge();
		
		while (age!=pAge) {
			if (age>pAge) {
				decAge();
			}
			if (age<pAge) {
				incAge();
			}
			if (age==pAge) {
				break;
			}
		}
	
		
	}
	
	public void clickNext() {
		clickElement(By.cssSelector(".btn.btn-next.btn-primary.hidden-print.ng-binding"));
	}
	
}
