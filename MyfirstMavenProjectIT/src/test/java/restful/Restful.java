package restful;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Restful 
{
	@Parameters ({"systemUnderTest"})
	@Test (groups= {"SmokeTest"})  
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

	
}
