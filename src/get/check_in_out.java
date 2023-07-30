package get;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class check_in_out {

	public static void main(String[] args) 
	{
       RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	   String responseBody = given().header("Content-Type", "application/json").
				              queryParam("checkin", "2019-03-13").
                              queryParam("checkout", "2019-05-21").
                              when().get("/booking").then().extract().response().asString();
				              	
		System.out.println(responseBody);
		

	}

}
