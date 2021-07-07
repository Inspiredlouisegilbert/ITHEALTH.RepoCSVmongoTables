package restful;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*;


public class Demo 
{
    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"2\" \n}";
	
	//@Test
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
	
	//@Test
    public void statusCode() {	
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		statusCode(200);
    }

	//@Test
    public void pathtest() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2));
    }
    
    //@Test
    public void testDataIDofData0() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[0].id", equalTo(7));
    }
    
    //@Test
    public void testDataIDofData0Extract() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[0].id", equalTo(7));
    }
    
    
    //@Test
    public void testDataIDofDataLastName() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[1].last_name", equalTo("Funke"));
    }
    
    //@Test
    public void testDataIDofDataAvatar() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[5].avatar", equalTo("https://reqres.in/img/faces/12-image.jpg"));
    }
    
    //@Test
    public void testDataIDofDataEmail() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("page",equalTo(2),
    				"data[3].email", equalTo("byron.fields@reqres.in"));
    }
	
	//@Test
    public void pathtest2() {
    	given().
    	when().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		assertThat().
    		body("per_page",equalTo(6));
    }

	//@Test
    public void statusCodePage4() {	
    	given().
    	when().
    		get("https://reqres.in/api/users?page=4").
    	then().
    		statusCode(200);
    }
    
    //@Test
    public void howManyDataElements() {
    	given().when().get("https://reqres.in/api/users?page=2")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("size()", equalTo(6));
    }
    
    //@Test
    public void testCount() {
    	given().when().get("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("count",equalTo(1118));
    }
    
    //@Test
    public void size() {
    	given().when().get("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("results.size()",equalTo(4));
    }
    
   // @Test
    public void queryparma() {	
	   given().queryParam("limit","100")
       .queryParam("offset","200")
       .when().get("https://pokeapi.co/api/v2/pokemon").then().log()
       .body();
	}
    
    //@Test
    public void firstElement() {
    	given().when().get("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("results[1].name",equalTo("wobbuffet"));
    }
    
    //@Test
    public void supportURL() {
    	given().when().get("https://reqres.in/api/users?page=2")
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("support.url",equalTo("https://reqres.in/#support-heading"));
    }

    	
	
	//@Test
    public void givenExample() {	
	   given().queryParam("CUSTOMER_ID","68195")
       .queryParam("PASSWORD","1234!")
       .queryParam("Account_No","1")
       .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
       .body();
	}
	
	//@Test
    public void givenExampleStatusCode() {	
	   given().queryParam("CUSTOMER_ID","68195").
	   when().
	   		get("http://demo.guru99.com/V4/sinkministatement.php").
       then().
       		statusCode(200);
	}
    
    //@Test
    public void getHeaders() {
 
    	System.out.println(given().when().get("https://reqres.in/api/users?page=2").then().extract().headers());
    }
    
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    
    @Test
    public void postRequest() {

    	//RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    	//HTTP POST request is used to post data or create a resource on a server.
		Response response = 
				given()
                	.header("Content-type", "application/json")
                	.and().body(requestBody)
                .when()
                	.post("/posts/103")
                .then().
                	//.extract().response();
					log().
					all().
					extract().
					response();
		
		Assert.assertEquals(201, response.statusCode());
		Assert.assertEquals("foo", response.jsonPath().getString("title"));
		Assert.assertEquals("bar", response.jsonPath().getString("body"));
		Assert.assertEquals("2", response.jsonPath().getString("userId"));
		Assert.assertEquals("101", response.jsonPath().getString("id"));
    }  
    
    @Test
    public void putRequest() {

    	//RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    	//The PUT request updates a resource but requires the full JSON payload.
		Response response = 
				given()
                	.header("Content-type", "application/json")
                	.and().body(requestBody)
                .when()
                	.put("/posts/7")
                .then().
                	//.extract().response();
					log().
					all().
					extract().
					response();
		
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals("foo", response.jsonPath().getString("title"));
		Assert.assertEquals("bar", response.jsonPath().getString("body"));
		Assert.assertEquals("2", response.jsonPath().getString("userId"));
		Assert.assertEquals("7", response.jsonPath().getString("id"));
    } 
}
