/*
package update;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;

public class full {

	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String requestBody = "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}" ;
		
		JsonPath jsprequest = new JsonPath(requestBody) ;
		String req_firstname = jsprequest.getString("firstname");
		String req_lastname = jsprequest.getString("lastname");
		int req_totalprice = jsprequest.getInt("totalprice");
		String req_depositpaid = jsprequest.getString("depositpaid");
		String req_additionalneeds = jsprequest.getString("additionalneeds");
		
		System.out.println(requestBody);
		
		String responseBody = given().header("Content-Type", "application/json" ,"Accept" ,"application/json","Cookie" ,"token=abc123")
				.when().put("/booking/1").then().extract().response().asString();
		
		JsonPath jspresponse = new JsonPath(responseBody) ;
		String res_firstname = jsprequest.getString("firstname");
		String res_lastname = jsprequest.getString("lastname");
		int res_totalprice = jsprequest.getInt("totalprice");
		String res_depositpaid = jsprequest.getString("depositpaid");
		String res_additionalneeds = jsprequest.getString("additionalneeds");
		
		System.out.println(responseBody);
		
		Assert.assertEquals(req_firstname, res_firstname);
		Assert.assertEquals(req_lastname, res_lastname);
		Assert.assertEquals(req_totalprice, res_totalprice);
		Assert.assertEquals(req_depositpaid, res_depositpaid);
		Assert.assertEquals(req_additionalneeds, res_additionalneeds);
	
	}

}
*/

package update;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;

public class full {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        String requestBody = "{\r\n"
                + "    \"firstname\" : \"James\",\r\n"
                + "    \"lastname\" : \"Brown\",\r\n"
                + "    \"totalprice\" : 111,\r\n"
                + "    \"depositpaid\" : true,\r\n"
                + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n"
                + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n"
                + "    \"additionalneeds\" : \"Breakfast\"\r\n"
                + "}";

        JsonPath jsprequest = new JsonPath(requestBody);
        String req_firstname = jsprequest.getString("firstname");
        String req_lastname = jsprequest.getString("lastname");
        int req_totalprice = jsprequest.getInt("totalprice");
        boolean req_depositpaid = jsprequest.getBoolean("depositpaid"); // Corrected to boolean type
        String req_additionalneeds = jsprequest.getString("additionalneeds");

        System.out.println(requestBody);

        String responseBody = given().header("Content-Type", "application/json", "Accept", "application/json")
                .header("Cookie", "token=abc123")
                .body(requestBody)
                .when()
                .put("/booking/1") // Replace "1" with the actual booking ID you want to update
                .then()
                .extract().response().asString();

        System.out.println(responseBody);

        JsonPath jspresponse = new JsonPath(responseBody);
        String res_firstname = jspresponse.getString("firstname");
        String res_lastname = jspresponse.getString("lastname");
        int res_totalprice = jspresponse.getInt("totalprice");
        boolean res_depositpaid = jspresponse.getBoolean("depositpaid"); // Corrected to boolean type
        String res_additionalneeds = jspresponse.getString("additionalneeds");

        Assert.assertEquals(req_firstname, res_firstname);
        Assert.assertEquals(req_lastname, res_lastname);
        Assert.assertEquals(req_totalprice, res_totalprice);
        Assert.assertEquals(req_depositpaid, res_depositpaid);
        Assert.assertEquals(req_additionalneeds, res_additionalneeds);
    }
}
