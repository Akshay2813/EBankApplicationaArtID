package RestAPIDemoPackage;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RestAPIDemo {
	
	
	@Given("service is up and running")
	public void service_is_up_and_running() {
	    System.out.println("service_is_up_and_running");
	}

	@When("user makes REST api call")
	public void user_makes_rest_api_call() {
		
		System.out.println("Calling API"); 
		
	}

	@Then("response should have {string}")
	public void response_should_have(String string) {
		
		System.out.println("Checking Response Status Code");
	    
	}

}
