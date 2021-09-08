package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightDetailsPage extends BasePage{

    private WebDriver driver;

    private By tripTotal = By.cssSelector("td h3.uitk-heading-5");
    private By tripTotalAmount = By.cssSelector("td span.uitk-text");
    private By departureMoreInfo = By.cssSelector("div[data-test-id='show-details-link'] button");
    private By returnMoreInfo = By.cssSelector("div[data-test-id='flight-review-1'] div[data-test-id='show-details-link'] button");
    // private By checkoutButton =By.cssSelector("button[data-test-id='goto-checkout-button']:not([disabled=''])");
    private By checkoutButton = By.cssSelector("button[data-test-id='goto-checkout-button']");
    private By addCarButton = By.cssSelector("data-stid='ground_transfers_add_to_trip'");

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public FlightCheckoutPage clickCheckout() {
        clickElement(checkoutButton);
        return new FlightCheckoutPage(driver);
    }

    public void waitForPageToLoad() {
        waitForElementToBeVisible(By.cssSelector("td h3.uitk-heading-5"));
    }

    public void addCar() {
        clickElement(addCarButton);
    }

    public boolean tripTotalIsPresent() {
        return driver.findElement(tripTotal).getText().contains("Trip total")
                && driver.findElement(tripTotalAmount).getText().contains("$");
    }

    public boolean departureAndReturnInfoArePresent() {
        return driver.findElement(returnMoreInfo).getText().contains("Show details")
                && driver.findElement(departureMoreInfo).getText().contains("Show details");
    }

}
