package restful;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.Assert;
//import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
//import static org.hamcrest.CoreMatchers;

//import com.aventstack.extentreports.gherkin.model.Given;

public class Restful {
	

    @Test
	public void firstApiTest ()  {
		System.out.println( "Hello World!" );
//		Response responsess = get("https://reqres.in/api/users?page=2");
//		boolean doesContain = responsess.getBody().asString().contains("michael.lawson@reqres.in");
//		System.out.println(responsess.getBody().asString());
//		System.out.println(responsess.getStatusCode());
//		System.out.println(responsess.getStatusLine());	
//		System.out.println(responsess.time());	
//		int responseCode = responsess.getStatusCode();
		//Assert.assertEquals(responseCode, 200);
	
		//Assert.assertTrue(doesContain);
		
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=535043
		//Response responsess = given().when().log().all().get("https://reqres.in/api/users?page=2").then().log().all().extract().response();

		//.setContentType(ContentType.JSON)
		

//		RestAssured.
					given().
						get("https://reqres.in/api/users?page=2").	
					then().
						statusCode(200)
						.log().all();//.body("kk", "llk");//.
					//body("page", equals(2));
		

	}

}
