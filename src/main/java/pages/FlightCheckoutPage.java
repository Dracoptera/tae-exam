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
        this.driver = driver;
    }

    public void waitForPageToLoad() {
        waitForElementToBeVisible(firstNameField);
    }

    public boolean travellerInfoIsPresent() {
        return driver.findElement(firstNameField).isDisplayed() && driver.findElement(lastName).isDisplayed()
                && driver.findElement(phoneField).isDisplayed();
    }

    public boolean insuranceIsPresent() {
        return driver.findElement(insuranceSection).isDisplayed();
    }

    public boolean paymentIsPresent() {
        return driver.findElement(paymentSection).isDisplayed();
    }
}
