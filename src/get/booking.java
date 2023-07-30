package get;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class booking {

	public static void main(String[] args) 
	{
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		
		String responseBody = given().header("Content-Type", "application/json").when().get("/booking/1").then()
							  .extract().response().asString();
		
		System.out.println(responseBody);
		
	
	

	}

}
