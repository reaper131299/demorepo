package stepdefinationfiles;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import myframework1.framework.base;
import resources.loginPage;
import resources.loginPage2;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinations extends base {

	    @Given("^initialize driver with chrome$")
	    public void initialize_driver_with_chrome() throws Throwable {
	    	driver = initializeBrowser();
	       
	    }
	    
	    @When("^user enter (.+) and (.+) and click on login$")
	    public void user_enter_and_and_click_on_login(String username, String password) throws Throwable {
	    	loginPage2 logp = new loginPage2(driver);
			logp.Login().sendKeys(username);
			logp.Password().sendKeys(password);
			logp.SighInButton().click();
	    }

	    @Then("^verify user is loggedin successfully$")
	    public void verify_user_is_loggedin_successfully() throws Throwable {
	        System.out.println("you are logged in");
	        driver.close();
	    }

	    @And("^navigate to \"([^\"]*)\"$")
	    public void navigate_to_something(String strArg1) throws Throwable {
	    	driver.get(strArg1);
	    }

	    @And("^lick on login button$")
	    public void lick_on_login_button() throws Throwable {
	    	loginPage lp = new loginPage(driver);
	    	if(lp.popupsize()>0) {
	    		lp.popup().click();
	    	}
			lp.login().click();
	    }
}