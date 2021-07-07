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


public class HTTPpostDemo 
{
	
    private static String requestBody = "{\n" +
            "  \"participant1\": \"Josh\",\n" +
            "  \"participant2\": \"Eon\",\n" +
            "  \"participant3\": \"Solo\",\n" +
            "  \"participant4\": \"Nyeleti\",\n" +
            "  \"participant5\": \"Thabiso\",\n" +
            "  \"participant6\": \"Mboni\" \n}";
    
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getRequest() {
    	Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();
    	
    	//HTTP POST request is used to post data or create a resource on a server.
    	//To send a POST request in REST-assured, we use the post() method:
    	Assert.assertEquals(response.statusCode(),201);
    	Assert.assertEquals(response.jsonPath().getString("participant1"),"Josh");
    	Assert.assertEquals(response.jsonPath().getString("participant2"),"Eon");
    	Assert.assertEquals(response.jsonPath().getString("participant3"),"Solo");
    	Assert.assertEquals(response.jsonPath().getString("participant4"),"Nyeleti");
    	Assert.assertEquals(response.jsonPath().getString("participant5"),"Thabiso");
    	Assert.assertEquals(response.jsonPath().getString("participant6"),"Mboni");
    }
}
