package common_method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given ;

public class API_CM_create_booking 
{
	public static int StatusCode(String baseURI, String Resource , String RequestBody) 
	{
		RestAssured.baseURI  = "https://restful-booker.herokuapp.com" ;
		int StatusCode = given().headers("Content-Type","Application/Json").body(RequestBody).when().post(Resource)
				         .then().extract().statusCode();
		return StatusCode ;
	}
	public static String ResponseBody(String baseURI, String Resource , String RequestBody) 
	{
		RestAssured.baseURI  = "https://restful-booker.herokuapp.com" ;
		String ResponseBody = given().headers("Content-Type","Application/Json").body(RequestBody).when().post(Resource)
				              .then().extract().response().asString() ;
		return ResponseBody ;
	}
		

}
