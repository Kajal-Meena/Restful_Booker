package Auth;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class create_token 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String requestBody = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}" ;
		
		System.out.println(requestBody);
			
		String responseBody = given().header("Content-Type", "application/json").body(requestBody).when().post("/auth").then().
				              extract().response().asString();
		
		JsonPath jspresponse = new JsonPath(responseBody);
		String res_token = jspresponse.getString("token");
	
		System.out.println("Token: " + res_token);


        Assert.assertNotNull(res_token, "Token is null");


	
	}

}
