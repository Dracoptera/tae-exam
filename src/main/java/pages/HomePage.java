package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    // TODO implement implicit waits

    private WebDriver driver;
    private WebDriverWait wait;

    // Travel option selectors
    private By staysLink = By.cssSelector("ul>li:nth-child(1)");
    private By flightsLink = By.cssSelector("ul>li:nth-child(2)");
    private By packagesLink = By.cssSelector("ul>li:nth-child(4)");
    private By cruisesLink = By.cssSelector("ul>li:nth-child(6)");

    // Calendar pickers - these share the same id for all travel options
    private By firstDate = By.id("d1-btn");
    private By finalDate  = By.id("d2-btn");
    private By firstDayOfMonth = By.cssSelector("[data-day='1']");
    private By lastDayOfMonth = By.cssSelector("[data-day='28']");
    private By dateDoneButton = By.cssSelector("[data-stid='apply-date-picker']");

    // Input selectors - Stays
    private By staysDestination = By.id("location-field-destination-input");
    private By staysDestinationInput = By.id("location-field-destination");
    private By staysAddFlight = By.id("add-flight-switch");

    // Input selectors - Flights
    private By flightsOrigin = By.id("location-field-leg1-origin-menu");
    private By flightsOriginInput = By.id("location-field-leg1-origin");
    private By flightsDestination = By.id("location-field-leg1-destination-menu");
    private By flightsDestinationInput = By.id("location-field-leg1-destination");
    private By flightsNextMonthArrow = By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]");

    // Input selectors - Packages
    private By packagesOrigin = By.id("location-field-origin-menu");
    private By packagesDestination = By.id("location-field-destination-menu");

    // Suggested result selectors - Flights
    private By flightsOriginSuggestedResult = By.cssSelector("button.uitk-button[data-stid='location-field-leg1-origin-result-item-button']");
    private By flightsDestinationSuggestedResult = By.cssSelector("[data-stid='location-field-leg1-destination-result-item-button']");

    // Search buttons
    private By flightsSearchButton = By.cssSelector("button[data-testid='submit-button']");

    // Constructor - uses the driver that has launched the browser
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 3);
    }

    // click methods
    public void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void clickFlightsLink() {
        clickElement(flightsLink);
    }

    // sendKeys methods - Stays
    public void setStaysDestination(String destination) {
        driver.findElement(staysDestination).sendKeys(destination);
    }

    // sendKeys methods - Flights
    public void setFlightsOrigin(String origin) {
        driver.findElement(flightsOrigin).click();
        driver.findElement(flightsOriginInput).sendKeys(origin);
        driver.findElement(flightsOriginSuggestedResult).click();
    }

    public void setFlightsDestination(String destination) {
        driver.findElement(flightsDestination).click();
        driver.findElement(flightsDestinationInput).sendKeys(destination);
        driver.findElement(flightsDestinationSuggestedResult).click();
    }

    public void setFlightsDepartureDate() {
        clickElement(firstDate);
        for(int i = 0; i < 4; i++) {
            clickElement(flightsNextMonthArrow);
        }
        clickElement(firstDayOfMonth);
        clickElement(lastDayOfMonth);
        clickElement(dateDoneButton);
    }

    // Page handlers - Flights
    public FlightsPage clickFlightsSearch() {
        driver.findElement(flightsSearchButton).click();
        return new FlightsPage(driver);
    }
}
