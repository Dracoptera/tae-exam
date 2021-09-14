package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightCheckoutPage extends BasePage {
    private WebDriver driver;

    private By firstNameField = By.id("firstname[0]");
    private By lastName = By.id("lastname[0]");
    private By phoneField = By.id("phone-number[0]");
    private By insuranceSection = By.id("insurance");
    private By paymentSection = By.id("payments");

    public FlightCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForElementToBeVisible(firstNameField);
    }

    public boolean travellerInfoIsPresent() {
        return getDriver().findElement(firstNameField).isDisplayed() && getDriver().findElement(lastName).isDisplayed()
                && getDriver().findElement(phoneField).isDisplayed();
    }

    public boolean insuranceIsPresent() {
        return getDriver().findElement(insuranceSection).isDisplayed();
    }

    public boolean paymentIsPresent() {
        return getDriver().findElement(paymentSection).isDisplayed();
    }
}
