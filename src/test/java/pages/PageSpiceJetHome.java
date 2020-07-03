package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSpiceJetHome {
    WebDriver driver;
    //Initialize the driver object.
    public PageSpiceJetHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="divpaxinfo")
    WebElement passengers;

    @FindBy(id = "ctl00_mainContent_ddl_Adult")
    WebElement adults;

    @FindBy(id="ctl00_mainContent_ddl_Child")
    WebElement child;

    public WebElement getPassengers() {
        return passengers;
    }

    public Select selectAdults() {
        return new Select(adults);
    }

    public Select selectChild() {
        return new Select(child);
    }
}
