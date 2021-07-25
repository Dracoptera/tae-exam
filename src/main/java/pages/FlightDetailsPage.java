package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightDetailsPage extends BasePage{

    private WebDriver driver;


    private By innerAnnouncement = By.id("uitk-live-announce");
    private By emptyBody = By.cssSelector("[data-test-id='summary-skeleton']");
    private By priceSummary = By.cssSelector("[data-test-id='price-summary-loading']");
    private By tripTotal = By.cssSelector("td h3.uitk-heading-5");
    private By tripTotalAmount = By.cssSelector("td span.uitk-text");
    private By departureInfo = By.cssSelector("div[data-test-id='flight-review-0'] div h2");
    private By returnInfo = By.cssSelector("div[data-test-id='flight-review-1'] div h2");
    // private By checkoutButton =By.cssSelector("button[data-test-id='goto-checkout-button']:not([disabled=''])");
    private By checkoutButton = By.cssSelector("button[data-test-id='goto-checkout-button']");
    private By skeletonTest = By.cssSelector("div[role='presentation']");
    private By priceTable = By.cssSelector("div table.experimental-pricing");

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public FlightCheckoutPage clickCheckout() {
        clickElement(checkoutButton);
        return new FlightCheckoutPage(driver);
    }

    public void waitForPageToLoad() {
        // waitForElementToBeClickable(checkoutButton);
        // waitForElementToDisappear(skeletonTest);
        // waitForElementToDisappear(priceSummary);
        waitForElementToBeVisible(priceTable);
        // waitForAnnouncementText(innerAnnouncement, "Loading flight details for your Las Vegas to Los Angeles Roundtrip journey");
        // waitForElementTest(driver.findElement(skeletonTest));
    }

    public boolean tripTotalIsPresent() {
        // waitForPageToLoad();
        // waitForElementToBeVisible(tripTotalAmount);
        System.out.println(driver.findElement(tripTotal).getText());
        System.out.println(driver.findElement(tripTotalAmount).getText());
        return driver.findElement(tripTotal).getText().contains("Trip total")
                && driver.findElement(tripTotalAmount).getText().contains("$");
    }

    public String tripTotalHeader() {
        // waitImplicitly();
        // waitForElementToBeClickable(checkoutButton);
        // System.out.println(driver.findElement(tripTotal).getText());
        System.out.println(driver.findElement(By.cssSelector("td h3.uitk-heading-5")).getText());
        return driver.findElement(By.cssSelector("td h3.uitk-heading-5")).getText();
    }
}
