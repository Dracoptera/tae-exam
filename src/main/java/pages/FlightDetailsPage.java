package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightDetailsPage extends BasePage{

    private WebDriver driver;

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By innerAnnouncement = By.id("uitk-live-announce");
    private By emptyBody = By.cssSelector("div[data-test-id='summary-skeleton']");
    private By tripTotal = By.cssSelector("table[data-test-id='trip-total'] h3");
    private By tripTotalAmount = By.cssSelector("table[data-test-id='trip-total'] span.uitk-text");
    private By departureInfo = By.cssSelector("div[data-test-id='flight-review-0'] div h2");
    private By returnInfo = By.cssSelector("div[data-test-id='flight-review-1'] div h2");
    private By checkoutButton =By.cssSelector("button[data-test-id='goto-checkout-button']");

    public FlightCheckoutPage clickCheckout() {
        clickElement(checkoutButton);
        return new FlightCheckoutPage(driver);
    }

    public boolean tripTotalIsPresent() {
        waitForElementToDisappear(emptyBody);
        waitForElementToBeClickable(checkoutButton);
        // waitForAnnouncementText(innerAnnouncement, "Loading flight details for your Las Vegas to Los Angeles Roundtrip journey");
        return driver.findElement(tripTotal).getText().contains("Trip total")
                && driver.findElement(tripTotalAmount).getText().contains("$");
    }
}
