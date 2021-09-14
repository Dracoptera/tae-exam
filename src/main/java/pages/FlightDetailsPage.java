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
    private By finalDetailsButton = By.cssSelector("[data-stid='goto-checkout-button']");
    private By addCarButton = By.cssSelector("button[data-stid='ground_transfers_add_to_trip']");

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
    }

    public FlightCheckoutPage clickCheckout() {
        clickElement(checkoutButton);
        return new FlightCheckoutPage(getDriver());
    }

    public FlightCheckoutPage clickFinalDetails() {
        clickElement(finalDetailsButton);
        return new FlightCheckoutPage(getDriver());
    }

    public void waitForPageToLoad() {
        waitForElementToBeVisible(By.cssSelector("td h3.uitk-heading-5"));
    }

    public void addCar() {
        clickElement(addCarButton);
    }

    public boolean tripTotalIsPresent() {
        return getDriver().findElement(tripTotal).getText().contains("Trip total")
                && getDriver().findElement(tripTotalAmount).getText().contains("$");
    }

    public boolean departureAndReturnInfoArePresent() {
        return getDriver().findElement(returnMoreInfo).getText().contains("Show details")
                && getDriver().findElement(departureMoreInfo).getText().contains("Show details");
    }

}
