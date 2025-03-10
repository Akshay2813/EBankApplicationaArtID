package RestAPIDemoPackage;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo_2 {
	
	//static Logger logger = LogManager.getLogger(Demo_2.class);
	@Given("user makes REST api call with {string} and with method {string}")
	public static Response user_makes_rest_api_call_with_and_with_method(String url, String method) {
	//RestAssured.baseURI=url;
	//logger.info("Calling API");
	Response response= null;
	
	//Create request object
	RequestSpecification httpRequest=RestAssured.given();
	
	//addding header paramter
	httpRequest.header("Content-Type","application/json");
	
	if(method.equalsIgnoreCase("GET"))
	{
	//Response response =httpRequest.request(Method.GET);
	 response =httpRequest.get(url);
	 //assert.assertTrue(response != null, "Response is null");
//( response != null. "Response is null", "Response is Not null");
	
	}
	else if(method.equalsIgnoreCase("POST"))
	{
		JSONObject requestBodyParameter = new JSONObject();
		
		//Adding Body paramters
		
		requestBodyParameter.put("FirstName", "Akshay");
		
		requestBodyParameter.put("LastName", "Shelke");
		
		//Specifiy Body COntent type
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestBodyParameter.toJSONString());
		
		response = httpRequest.post(url);
		
	}
	//logger.info("printing Response");
	System.out.println(response.getBody().asString());
	return response;
}


}
