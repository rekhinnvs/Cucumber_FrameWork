package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinitions {

    @Given("^User is on the landing page$")
    public void user_is_on_the_landing_page() throws Throwable {
        System.out.println("At landing page");
    }

    @When("^User logins with username and password$")
    public void user_logins_with_username_and_password() throws Throwable {
        throw new PendingException();
    }

    @Then("^Home page is displayed$")
    public void home_page_is_displayed() throws Throwable {
        throw new PendingException();
    }
}
