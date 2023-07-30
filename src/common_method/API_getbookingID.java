package common_method;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class API_getbookingID 
{
	public static int StatusCode(String baseURI, String Resource) 
	{
		RestAssured.baseURI  = "https://restful-booker.herokuapp.com" ;
		int StatusCode = given().headers("Content-Type","Application/Json").when().get("/booking")
				         .then().extract().statusCode();
		return StatusCode ;
	}
	public static String ResponseBody(String baseURI, String Resource ) 
	{
		RestAssured.baseURI  = "https://restful-booker.herokuapp.com" ;
		String ResponseBody = given().header("Content-Type", "Application/Json").when().get("/booking").then()
							  .extract().response().asString();
		return ResponseBody ;
	}
}
