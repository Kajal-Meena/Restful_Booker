package test_class;

import common_method.API_get_booking_details;
import repository.get_booking_details;

public class TC_get_booking_details 
{
	public static void extractor() 
	{
		int StatusCode = API_get_booking_details.StatusCode(get_booking_details.baseURI(),get_booking_details.Resource());
	    
	    System.out.println(StatusCode);
    
	    String ResponseBody = API_get_booking_details.ResponseBody(get_booking_details.baseURI(),get_booking_details.Resource());
	    		             
	    System.out.println(ResponseBody);
	    
}
}