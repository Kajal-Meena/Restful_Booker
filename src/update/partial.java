package update;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class partial {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

		String requestBody = "{\r\n" + "    \"firstname\" : \"James\",\r\n" + "    \"lastname\" : \"Brown\"\r\n" + "}";

		System.out.println(requestBody);

		String responseBody = given().header("Content-Type", "application/json").header("Accept", "application/json")
				.header("Cookie", "token=abc123").body(requestBody).when().patch("/booking/1").then().extract()
				.response().asString();

		System.out.println("Response Body:");
		System.out.println(responseBody);

		JsonPath jspresponse = new JsonPath(responseBody);
		String res_firstname = jspresponse.getString("firstname");
		String res_lastname = jspresponse.getString("lastname");
		int res_totalprice = jspresponse.getInt("totalprice");
		boolean res_depositpaid = jspresponse.getBoolean("depositpaid");
		String res_checkin = jspresponse.getString("bookingdates.checkin");
		String res_checkout = jspresponse.getString("bookingdates.checkout");
		String res_additionalneeds = jspresponse.getString("additionalneeds");

		System.out.println("First Name: " + res_firstname);
		System.out.println("Last Name: " + res_lastname);
		System.out.println("Total Price: " + res_totalprice);
		System.out.println("Deposit Paid: " + res_depositpaid);
		System.out.println("Check-in: " + res_checkin);
		System.out.println("Check-out: " + res_checkout);
		System.out.println("Additional Needs: " + res_additionalneeds);

		// Perform any additional validations or assertions as needed
	}
}
