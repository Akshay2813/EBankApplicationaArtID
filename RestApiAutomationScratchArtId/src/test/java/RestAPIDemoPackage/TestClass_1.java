package RestAPIDemoPackage;


import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClass_1 {
	
	//https://www.google.com/maps/123?grp=point&grp2=pp
	//server : https://www.google.com
	//Base URI : google.com 
	//Resource : /maps
	//path param : 123point speocific resouces
	//Query pamanter : grp=point & grp2=pp : sort.filter resouver
	
	@Test
	public void TC_01_GET(String url, Map<String,String> headers, String QueryPathParmater ) 
	{
		RestAssured.baseURI=url;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		for(Entry<String, String> h : headers.entrySet() )
		{
			httpRequest.header(h.getKey(),h.getValue());
		}
		
		Response  response = httpRequest.request(Method.GET,QueryPathParmater);
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(200, statusCode);
		
		String statusMessage= response.statusLine();
		
		Assert.assertEquals(true, statusMessage.contains("OK"));	
		
		String responseBody= response.getBody().asString();
		
		JsonPath jsonPath = response.jsonPath();
		
		String s= jsonPath.get("ResponsParameterWeWant");	//jsonPath.get("City")  and we wiill get Delhi (Response City:Delhi)
		
		
		
		//get all response header
		Headers allResponseHeader= response.headers();
		
		//iterate headers
		for(Header h:allResponseHeader)
		{
			System.out.println(h.getName()+" : "+h.getValue());
		}
		
		//get particluar header
		
		String h1=response.header("Content-Type");
		

			
	}
	
	
	@Test
	public void TC_02_POST(String url, Map<String,String> headers, String QueryPathParmater, Map<String,String> bodyParam) 
	{
		//Specifiy URL
		RestAssured.baseURI=url;
		//create a request
		RequestSpecification httpRequest = RestAssured.given();
		//add header parameters along with body content Type
		for(Entry<String, String> h : headers.entrySet() )
		{
			httpRequest.header(h.getKey(),h.getValue());
		}
		//add Body 
		
		JSONObject requestBodyParam = new JSONObject();
		
		for(Entry<String, String> b : bodyParam.entrySet() )
		{
			requestBodyParam.put(b.getKey(), b.getValue());
		}
		
		httpRequest.body(requestBodyParam.toJSONString());
		
		Response  response = httpRequest.request(Method.POST,QueryPathParmater);
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(200, statusCode);
		
		String statusMessage= response.statusLine();
		
		Assert.assertEquals(true, statusMessage.contains("OK"));	
		
		String responseBody= response.getBody().asString();
		
		JsonPath jsonPath = response.jsonPath();
		
		String s= jsonPath.get("ResponsParameterWeWant");		
			
			
	}
	
	@Test
	public void TC_03_AuthAPI()
	{
		RestAssured.baseURI="OURURL";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
		
		JSONObject requestBodyParam = new JSONObject();
		
		requestBodyParam.put("Para1", "Value1");
		requestBodyParam.put("Para2", "Value2");
		requestBodyParam.put("Para3", "Value3");
		
		httpRequest.body(requestBodyParam.toJSONString());
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		
		authScheme.setUserName("Admin1234");
		authScheme.setPassword("Test1234");
		
		RestAssured.authentication=authScheme;
			
	}
	
	
	@DataProvider(name="EmpData")
	public Object[][] getEmpData()
	{
		return new Object[][] {{"Akshay",20,"28-Feb"},{"Ajay",23,"3-Feb"},{"Amruta",22,"1-Feb"}};
	}
	
	@Test(dataProvider="EmpData")
	public void TC_04_dataProviderTC(String name, int age, String DOB)
	{
		System.out.println(name + " "+ age + " "+ DOB);
	}
	
	
	//Excel
	@DataProvider(name="WokerData")
	public Object[][] getWorkData()
	{
		
		int row=3;// wirte Excel uitility to get row
		int col=3; // wirte Excel uitility to get colum
		Object[][] workerData = new Object[row][col];
		for(int i=1; i<=row;i++)
		{
			for(int j=0;j<col;j++)
			{
				//workerData[i-1][j]=XLUtityCls.getCellData(path,sheet,i,j);
			}
		}
		return  workerData;
		
	}
	
	@Test(dataProvider="WokerData")
	public void TC_05_dataProviderExcel(String name, int age, String DOB)
	{
		System.out.println(name + " "+ age + " "+ DOB);
	}

}
