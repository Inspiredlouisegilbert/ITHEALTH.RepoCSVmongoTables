package frameworkclasses;

public class page_navigator extends BasePage {
   String Url = "";
	public void setuptest() {
		
		driver.navigate().to(Url);
	}
	
	public void getFromprop(String parameterName) {
	
		Url= getDataConfigProperties(parameterName);
		setuptest();
	}
	
	public void setCurrentUrl() {
		Url = driver.getCurrentUrl();
	}
	
	public void goToPrevTestPage() {
		
		driver.get(Url);
	}
}
