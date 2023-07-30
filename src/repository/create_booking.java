package repository;

public class create_booking 
{
	public static String baseURI() 
	{
		String baseURI = "https://restful-booker.herokuapp.com" ;
		return baseURI ;
	}
	public static String Resource() 
	{
		String Resource = "/booking";
		return Resource ;
	}
	public static String RequestBody() 
	{
		String RequestBody = "{\r\n"
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
		return RequestBody ;
	}
}
