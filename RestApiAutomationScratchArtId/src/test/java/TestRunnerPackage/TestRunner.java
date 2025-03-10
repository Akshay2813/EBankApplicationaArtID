package TestRunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		//plugin = {"pretty", "html:target/cucumber"},
		features="scenarios/demo_2.feature",
		monochrome=true,
		glue={"RestAPIDemoPackage"}

				)

public class TestRunner extends AbstractTestNGCucumberTests{
	
}






