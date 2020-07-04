package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageSpiceJetHome;
import utils.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@RunWith( Cucumber.class )
public class SpiceJetSelectPassengerStepDefinitions extends Base {
    WebDriver driver;
    Properties properties;
    PageSpiceJetHome pageSpiceJetHome;
    WebDriverWait wait;

    @Before
    public void setup() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
        properties.load(fis);
        System.out.println("in before method");
        driver = initializeDriver();
    }

    @After
    public void tearDown() {
        System.out.println("in after method");
        driver.quit();
    }

    @Given("I am on spicejet homepage")
    public void i_am_on_spicejet_homepage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Initialize the page object class.
        pageSpiceJetHome = new PageSpiceJetHome(driver);
        driver.get(properties.getProperty("spicejet"));
    }

    @When("I select {int} adult passengers")
    public void i_select_adult_passengers(Integer numberOfAdults) {
        System.out.println("I am on select adults "+numberOfAdults);
        wait.until(ExpectedConditions.textToBePresentInElement(pageSpiceJetHome.getPassengers(),"1 Adult"));
        pageSpiceJetHome.getPassengers().click();
        pageSpiceJetHome.selectAdults().selectByValue(numberOfAdults.toString());
    }

    @When("I select {int} child passengers")
    public void i_select_child_passengers(Integer numberOfChild) {
        System.out.println("I am on select Child");
        pageSpiceJetHome.selectChild().selectByValue(numberOfChild.toString());
    }

    @Then("{int} adult passengers are selected")
    public void adult_passengers_are_selected(Integer numberOfAdults) {
        Assert.assertEquals("Selected child",
                pageSpiceJetHome.selectAdults().getFirstSelectedOption().getText(),
                numberOfAdults.toString());

    }

    @Then("{int} child passengers are selected")
    public void child_passengers_are_selected(Integer numberOfChild) {
        Assert.assertEquals("Selected Child",
                pageSpiceJetHome.selectChild().getFirstSelectedOption().getText(),
                numberOfChild.toString());

    }

}
