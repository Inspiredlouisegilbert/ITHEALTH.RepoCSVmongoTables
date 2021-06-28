package dataProviders;

import org.testng.annotations.DataProvider;

public class NewToursDataProvider {
	
    @DataProvider(name="ToursValidUsers")
    public Object[][] getValidUsers(){
    return new Object[][] 
    	{
//    	Examples:	
//    		|First Name	|Country	|Username          | Password
//    		|Polela     |Russia 	|polela@gmail.com  |password@1
//    		|Faith 		|Spain  	|faith@gmail.com   |password@2
//    		|Mvuyo 		|Italy		|mvuyo@gmail.com   |password@3
//    		|Junaid 	|Brazil		|juanid@gmail.com  |password@4
            { "Polela", "Russia" ,"polela@gmail.com","password@1"},
            { "Faith", "Spain","faith@gmail.com","password@2" },
            { "Mvuyo", "Italy" ,"mvuyo@gmail.com","password@3"},
            { "Junaid", "Brazil" ,"juanid@gmail.com","password@4"}
        };
    }
    
    @DataProvider(name="ToursInvalidUsers")
    public Object[][] getDataFromDataproviderDifferent(){
    return new Object[][] 
    	{
            { "junaid12@gmail.com", "pass"},
            {  "muvyo12@gmail.com", "pass3"},
            { "polela12@gmail.com", "pass2"}
        };
    }
	

}
