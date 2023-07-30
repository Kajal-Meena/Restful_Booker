/*

package delete;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class DELETE_BOOKING {

	public static void main(String[] args) 
	{
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	String responseBody = given().header("Content-Type", "application/json")
                .header("Cookie", "token=80bd2956cc24085")
                .when()
                .delete("/booking/1")
                .then()
                .extract().response().asString();

		
		System.out.println(responseBody);

	}

}
*/


package delete;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE_BOOKING {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String token = "80bd2956cc24085"; // Replace with the correct token value

        Response response = given().header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/1"); // Replace "1" with the actual booking ID you want to delete

        // Print the HTTP status code
        int statusCode = response.getStatusCode();
        System.out.println("HTTP Status Code: " + statusCode);

        // Get the response body as a String
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Check if the request was successful (HTTP status code 201)
        if (statusCode == 201) {
            System.out.println("Booking with ID 1 is successfully deleted.");
        } else {
            System.out.println("Failed to delete booking with ID 1. Check the response body for details.");
        }
    }
}
