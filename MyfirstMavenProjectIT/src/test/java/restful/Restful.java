package restful;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*;


public class Restful 
{
	@Parameters ({"systemUnderTest"})
	//@Test (groups= {"Include"})
	//@Test (groups= {"SmokeTest"})  
	//@Test
    public void extractall(String systemUnderTest) {
    	
    	given().when().log().all().get(systemUnderTest).then().log().all().extract().response();
    }
	
	@Parameters ({"systemUnderTest"})
	@Test
    public void statusCode(String systemUnderTest) {

    	
    	given()
    	.when()
    	.get(systemUnderTest)
    	.then()
    	.statusCode(200);

    }
	@Parameters ({"systemUnderTest"})
	@Test
    public void pageEquals2(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("page",equalTo(2));

    }
	
	@Parameters ({"systemUnderTest"})
	@Test
    public void dataTest(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("page",equalTo(2),
    			"data[0].id", equalTo(7));

    }
	
	@Parameters ({"systemUnderTest"})
	@Test (groups= {"Include"})
    public void sumIds(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("data[0].email", equalTo("michael...lawson@reqres.in"));
	}
	


	@Parameters ({"systemUnderTest"})
	@Test
    public void supporttext(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }


	@Parameters ({"systemUnderTest"})
	@Test (groups= {"SmokeTest"})
	//@Test (groups= {"Include"})  
    public void getHeaders(String systemUnderTest) {

    	System.out.println(given().when().get(systemUnderTest).then().extract().headers());
    }
	
	@Parameters ({"systemUnderTestGuru"})
	//@Test (groups= {"Include"}) 
	public static void getResponseBody(String systemUnderTestGuru){
		 
//		   //String strAmount = 
		given().queryParam("CUSTOMER_ID","68195")
		           .queryParam("PASSWORD","1234!")
		           .queryParam("Account_No","1")
		           .when().get(systemUnderTestGuru).then()
		           .log().all().extract().response();
		           //.body("result.statements[0]",hasItems("TRANSACTION_ID"))
		           //.extract().path("'result:'.statements[0].AMOUNT");
		
		//ArrayList<String> amounts = when().get(systemUnderTestGuru).then().extract().path("result.statements.AMOUNT") ;
		   
		   //System.out.println("The response amount is "+ amounts);
		}
	
	@Parameters ({"systemUnderTestGuru"})
	@Test 
	public static void getResponseStatus(String systemUnderTestGuru){
		   int statusCode= given().queryParam("CUSTOMER_ID","68195")
		           .queryParam("PASSWORD","1234!")
		           .queryParam("Account_No","1") .when().get(systemUnderTestGuru).getStatusCode();
		   System.out.println("The response status is "+statusCode);

		   given().when().get(systemUnderTestGuru).then().assertThat().statusCode(200);
		}	
	
	@Parameters ({"systemUnderTestAcme"})
	@Test //(groups= {"Include"})  
	public void checkSiteIsUp(String systemUnderTestAcme) {
		 
		 given().when().get(systemUnderTestAcme).then().assertThat().statusCode(200);

	 }

}
