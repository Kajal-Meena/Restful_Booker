package test_class;


import common_method.API_getbookingID;
import repository.get_bookingID;

public class TC_getbookingID 
{

	public static void extractor() 
	{
		int StatusCode = API_getbookingID.StatusCode( get_bookingID .baseURI(), get_bookingID .Resource());
	    
	    System.out.println(StatusCode);
    
	    String ResponseBody = API_getbookingID.ResponseBody( get_bookingID .baseURI(), get_bookingID .Resource());
	    		             
	    System.out.println(ResponseBody);
	    
    }
}
