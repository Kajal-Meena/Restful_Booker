
package get;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class filter_by_name {

	public static void main(String[] args) 
	{
RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		
		String responseBody = given().header("Content-Type", "application/json").
				              queryParam("firstname","sally").queryParam("lastname","brown").when().get("/booking")
				               .then().extract().response().asString();
		  if (responseBody.equals("[]")) {
	            System.out.println("No bookings found matching the specified criteria.");
	        } else {
	            System.out.println(responseBody);
	        }
	    }
	}

