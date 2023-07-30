
package createBooking;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;

public class POST_CREATE {

	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String requestBody = "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}" ;
		
		System.out.println("request body is : " + requestBody);
		
		String responseBody = given().header("Content-Type", "application/json").when().body(requestBody).post("/booking").then().extract().response().asString();
		
		    JsonPath jspresponse = new JsonPath(responseBody);
            int bookingId = jspresponse.getInt("bookingid");
            String res_firstname = jspresponse.getString("booking.firstname");
            String res_lastname = jspresponse.getString("booking.lastname");
            int res_totalprice = jspresponse.getInt("booking.totalprice");
            boolean res_depositpaid = jspresponse.getBoolean("booking.depositpaid");
            String res_additionalneeds = jspresponse.getString("booking.additionalneeds");
		
		System.out.println("response body is : " + responseBody);
		System.out.println("New Booking ID is : " + bookingId);
		
            Assert.assertEquals("Jim", res_firstname);
            Assert.assertEquals("Brown", res_lastname);
            Assert.assertEquals(111, res_totalprice);
            Assert.assertEquals(true, res_depositpaid);
            Assert.assertEquals("Breakfast", res_additionalneeds);
	}

}

