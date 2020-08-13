package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/features",
		glue= "stepdefinationfiles")
public class testRunner extends AbstractTestNGCucumberTests {
	

}
