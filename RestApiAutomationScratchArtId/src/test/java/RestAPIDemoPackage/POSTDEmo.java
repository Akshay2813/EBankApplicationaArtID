package RestAPIDemoPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTDEmo {

	public void m1() {

		try {
			System.out.print(10 / 0);
		} catch (ArithmeticException e) {

		} catch (Exception e) {

		}

	}

	public static void rotate(int[] arr) // 1 2 3 4 5
	{
		int last_el = arr[arr.length - 1]; // 5
		for (int i = arr.length - 1; i > 0; i--) // 4 3 2 1
		{
			arr[i] = arr[i - 1]; // 4=3 3=2 2=1 1=0
		}
		arr[0] = last_el; // 5 4

	}

	@Test
	public void TC_1()
	{
		RestAssured.baseURI = "UulWewantrTest";
		RequestSpecification hhtprequest = RestAssured.given();

		// PreemptiveAuthScheme auth = new PreemptiveScheme();

		// auth.username

		// hhtprequest.header();

//		JSON Object requestparam = new JSONObject();
//		
//		requestparam.put();
//		
//		hhtprequest.body(requestparam.toJSONString(0));
//		
//		Response response = hhtprequest.post();

		// Select empName from EMPTable order by DESC Salary LIMIT 1
		//
	}

}
