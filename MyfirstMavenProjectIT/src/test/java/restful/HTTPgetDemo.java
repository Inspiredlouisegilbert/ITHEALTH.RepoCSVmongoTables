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


public class HTTPgetDemo 
{
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getRequest() {
    	//The HTTP GET request is used to fetch a resource from a server.
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("title[1]"),"qui est esse");
    }
    
    @Test
    public void getRequestWithQueryParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        
      Assert.assertEquals(response.jsonPath().getString("email[3]"),"Meghan_Littel@rene.us");
    }
    
    
    @Test
    public void geNameParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("name", "Leanne Graham")
                .when()
                .get("/users")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        
      Assert.assertEquals(response.jsonPath().getString("email[0]"),"Sincere@april.biz");
    }
}
