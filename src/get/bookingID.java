package get;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class bookingID {

	public static void main(String[] args) 
	{
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		
		String responseBody = given().header("Content-Type", "Application/Json").when().get("/booking")
							  .then().extract().response().asString();
		
		System.out.println(responseBody);
		
		

	}

}
