package RestAPIDemoPackage;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BasicGETRequest {

	public static void makeGETAPIRequrest(String url) {
		
		RestAssured.baseURI=url;
		//Create httpRequest
		RequestSpecification httpRequest = RestAssured.given();
		
		//Add Header
		
		httpRequest.header("Content-Type","application/json");
		
		//make Call anf get Response Object
		
		Response  response = httpRequest.request(Method.GET,"QueryParmater");
		
		//get ResponseBody
		
		String ResponseBody = response.getBody().asString();
		
		String contentType= response.getContentType();
		
		int statusCode = response.getStatusCode();
		
		String headerName = response.getHeader("HeaderName");
		
		//Below is response
		/* {"SucessCode:"File added",
		    "Message": "Done"	
		 * }*/ 
		
		String param1= response.jsonPath().get("SuceesCode");
		//Response body validation
		Assert.assertEquals(ResponseBody.contains("Message"), true);
		
		//Extract value jsonbodyPath
		
		JsonPath jsonPath= response.jsonPath();
		String s = jsonPath.get("Message");
		
		
		//get all header
		Headers allHeaders= response.getHeaders();
		for(Header h : allHeaders)
		{
			System.out.println(h.getName()+" : "+ h.getValue());
		}
		
		
		
		
		
		

	}

}
