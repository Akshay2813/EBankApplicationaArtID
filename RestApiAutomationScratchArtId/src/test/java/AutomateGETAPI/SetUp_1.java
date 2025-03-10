package AutomateGETAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SetUp_1 {
	
	
	@Test(dataProvider="getData")
	public static void setURL(String url)
	{
		RestAssured.baseURI=url;
	}
	
	@DataProvider(name="getData")
	public Object[][]  data()
	{
		return new Object[][] {};
	}

	
	public static void postRequest()
	{
		RestAssured.baseURI="";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("content-Type", "application/json");
		
		JSONObject bodyData = new JSONObject();
		bodyData.put("Name", "Ajay");
		bodyData.put("Age", 18);
		
		String[] coureseArr = {"C++", "python","java"};
		
		bodyData.put("Courses", coureseArr);
		
		httpRequest.body(bodyData.toJSONString());
		
		
		httpRequest.queryParam("Page", 2);
		httpRequest.pathParam("Path1", "location");
		
		httpRequest.auth().basic("UserName", "Password");
		
		httpRequest.auth().preemptive().basic("UserName", "Password");
		
		httpRequest.auth().digest("UserName", "Password");
		
		httpRequest.auth().oauth("consumerKey", "ConsumerSecret","accesToken" ,"TokenSecrte" );
		
		httpRequest.auth().oauth2("TOken");
		
		
		Response response = httpRequest.request(Method.POST,"/Path1");
		
		ResponseBody body = response.getBody();
		
		System.out.print(body.toString());
		
		int statusCode = response.getStatusCode();
		
		Headers headers = response.getHeaders();
		
		for(Header h: headers)
		{
			System.out.print(h.getName() +"=="+ h.getValue());
		}
		
		String singleHeader = response.getHeader("Content-Type");
		
		
		
		JsonPath path = response.jsonPath();
		path.get("$.Name");
		
		
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemafilelocation.json"));
		
		response.then().body(JsonSchemaValidator.matchesJsonSchema(""));

		
		
		
		
	}
}
