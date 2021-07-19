package mvuyoExam;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class HomePage extends BasePage {
	
	public void clickBargainBin() {
		clickJavascript(By.xpath("//body[1]/main[1]/header[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]/span[1]"));
	}
	

}
