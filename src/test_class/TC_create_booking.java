package test_class;

import org.testng.Assert;
import common_method.API_CM_create_booking;
import io.restassured.path.json.JsonPath;
import repository.create_booking;

public class TC_create_booking 
{
	public static void extractor() 
	{
		int StatusCode = API_CM_create_booking.StatusCode(create_booking.baseURI(),create_booking.Resource(),
				         create_booking.RequestBody()) ;
	    
	    System.out.println(StatusCode);
    
	    String ResponseBody = API_CM_create_booking.ResponseBody(create_booking.baseURI(),create_booking.Resource(),
	    		              create_booking.RequestBody()) ;
	   
	    System.out.println(ResponseBody);
	    
	    String RequestBody = create_booking.RequestBody() ;
	    
	    JsonPath jspresponse = new JsonPath(ResponseBody);
        int bookingId = jspresponse.getInt("bookingid");
        String res_firstname = jspresponse.getString("booking.firstname");
        String res_lastname = jspresponse.getString("booking.lastname");
        int res_totalprice = jspresponse.getInt("booking.totalprice");
        boolean res_depositpaid = jspresponse.getBoolean("booking.depositpaid");
        String res_additionalneeds = jspresponse.getString("booking.additionalneeds");
	
	System.out.println("response body is : " + ResponseBody);
	System.out.println("New Booking ID is : " + bookingId);
	
        Assert.assertEquals("Jim", res_firstname);
        Assert.assertEquals("Brown", res_lastname);
        Assert.assertEquals(111, res_totalprice);
        Assert.assertEquals(true, res_depositpaid);
        Assert.assertEquals("Breakfast", res_additionalneeds);
	}
}
