package stepDefinitions;


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

    @When("User logins with username {string} and password {string}")
    public void user_logins_with_username_and_password(String userName, String password) {
        System.out.println("Username "+ userName);
        System.out.println("Password "+ password);
    }

    @Then("Home page is displayed {string}")
    public void home_page_is_displayed(String string) {
        System.out.println(Boolean.valueOf(string));
    }
}
