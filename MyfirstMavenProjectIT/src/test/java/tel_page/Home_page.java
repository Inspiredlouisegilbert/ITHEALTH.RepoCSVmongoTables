package tel_page;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class Home_page extends BasePage {
	public void clickCustomer() {
		driver.findElement(By.xpath("//section[@id='one']/div/div[@class='flex-item left']//a[@href='addcustomer.php']")).click();
	}

}
