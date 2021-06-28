package dataProviders;

import org.testng.annotations.DataProvider;

public class DemoDataProviders {
	
    @DataProvider(name="SearchProviderClass")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99 Class", "India" },
            { "Krishna Class", "UK" },
            { "Bhupesh Class", "USA" }
        };
    }
    
    @DataProvider(name="SearchProviderDifferentClass")
    public Object[][] getDataFromDataproviderDifferent(){
    return new Object[][] 
    	{
            { "an Apple Class"},
            { "a Banana Class"},
            { "a bunch of Grapes Class"}
        };
    }
	

}
