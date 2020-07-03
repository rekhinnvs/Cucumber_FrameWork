package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.Base;

public class SpiceJetSelectPassengerStepDefinitions extends Base {
    WebDriver driver;

    @Before
    public void setup() {
        driver = initializeDriver();

    }

    @Given("I am on spicejet homepage")
    public void i_am_on_spicejet_homepage() {
        driver.get("");
    }

    @When("I select {int} adult passengers")
    public void i_select_adult_passengers(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I selectt {int} child passengers")
    public void i_selectt_child_passengers(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} adult passengers are selected")
    public void adult_passengers_are_selected(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} child passengers are selected")
    public void child_passengers_are_selected(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
