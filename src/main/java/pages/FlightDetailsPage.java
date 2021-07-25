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
    private By priceSummary = By.cssSelector("[data-test-id='price-summary-loading']");
    private By tripTotal = By.cssSelector("h3.uitk-heading-5");
    private By tripTotalAmount = By.cssSelector("td span.uitk-text");
    private By departureInfo = By.cssSelector("div[data-test-id='flight-review-0'] div h2");
    private By returnInfo = By.cssSelector("div[data-test-id='flight-review-1'] div h2");
    private By checkoutButton =By.cssSelector("button[data-test-id='goto-checkout-button']");

    public FlightCheckoutPage clickCheckout() {
        clickElement(checkoutButton);
        return new FlightCheckoutPage(driver);
    }

    public void waitForPageToLoad() {
        // waitForElementToDisappear(emptyBody);
        // waitForElementToDisappear(priceSummary);
        waitForElementToBeVisible(tripTotal);
        // waitForAnnouncementText(innerAnnouncement, "Loading flight details for your Las Vegas to Los Angeles Roundtrip journey");
    }

    public boolean tripTotalIsPresent() {
        // waitForPageToLoad();
        // waitForElementToBeVisible(tripTotalAmount);
        waitForElementToDisappear(priceSummary);
        System.out.println(driver.findElement(tripTotal).getText());
        System.out.println(driver.findElement(tripTotalAmount).getText());
        return driver.findElement(tripTotal).getText().contains("Trip total")
                && driver.findElement(tripTotalAmount).getText().contains("$");
    }
}
