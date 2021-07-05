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


public class Demo 
{

	
	@Test
    public void extractall() {
    	given().
    	when().
    		log().
    		all().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		log().
    		all().
    		extract().
    		response();
    }
	
	@Test
    public void statusCode() {	
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		statusCode(200);
    }

	@Test
    public void pathtest() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2));
    }
    
    @Test
    public void testDataIDofData0() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[0].id", equalTo(7));
    }
    
    @Test
    public void testDataIDofData0Extract() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[0].id", equalTo(7));
    }
    
    
    @Test
    public void testDataIDofDataLastName() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[1].last_name", equalTo("Funke"));
    }
    
    @Test
    public void testDataIDofDataAvatar() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[5].avatar", equalTo("https://reqres.in/img/faces/12-image.jpg"));
    }
    
    @Test
    public void testDataIDofDataEmail() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[3].email", equalTo("byron.fields@reqres.in"));
    }
	
	@Test
    public void pathtest2() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("per_page",equalTo(6));
    }

	@Test
    public void statusCodePage4() {	
    	given().
    	when().
    		get("https://reqres.in/api/users?page=4").
    	then().
    		statusCode(200);
    }
    
    @Test
    public void howManyDataElements() {
    	given().when().get("https://reqres.in/api/users?page=2")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("size()", equalTo(6));
    }
    
    @Test
    public void supportText() {
    	given().when().get("https://reqres.in/api/users?page=2")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
    
    @Test
    public void supportURL() {
    	given().when().get("https://reqres.in/api/users?page=2")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("support.url",equalTo("https://reqres.in/#support-heading"));
    }

    	
	
	@Test
    public void givenExample() {	
	   given().queryParam("CUSTOMER_ID","68195")
       .queryParam("PASSWORD","1234!")
       .queryParam("Account_No","1")
       .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
       .body();
	}
	
	@Test
    public void givenExampleStatusCode() {	
	   given().queryParam("CUSTOMER_ID","68195").
	   when().
	   		get("http://demo.guru99.com/V4/sinkministatement.php").
       then().
       		statusCode(200);
	}
    
    @Test
    public void getHeaders() {
 
    	System.out.println(given().when().get("https://reqres.in/api/users?page=2").then().extract().headers());
    }

}
