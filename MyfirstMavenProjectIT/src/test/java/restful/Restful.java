package restful;

//import io.restassured.RestAssured.*;
//import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

//import io.restassured.matcher.ResponseAwareMatcher;
//import io.restassured.matcher.RestAssuredMatchers.*;
//import io.restassured.response.ExtractableResponse;
//import io.restassured.response.Response;

//import static org.testng.Assert.*;

//import org.testng.annotations.*;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.hamcrest.Matchers.*;




public class Restful 
{
	
	@Test
    public void extractall() {
    	
    	given().when().log().all().get("https://reqres.in/api/users?page=2").then().log().all().extract().response();
    }
	
	//@Test
    public void statusCode() {

    	
    	given()
    	.when()
    	.get("https://reqres.in/api/users?page=2")
    	.then()
    	.statusCode(200);

    }

	//@Test
    public void pathtest() {


    	given().when().get("https://reqres.in/api/users?page=2")
    			.then()
    			.assertThat()
    			.body("page"
    					+ "",equalTo(2));

    }

	
}
