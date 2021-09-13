package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    // TODO clean Xpaths
    // Test comment

    private WebDriver driver;
    // private WebDriverWait wait;

    // Travel option selectors
    private By staysLink = By.cssSelector("ul>li:nth-child(1)");
    private By flightsLink = By.cssSelector("ul>li:nth-child(2)");
    private By packagesLink = By.cssSelector("ul>li:nth-child(4)");
    private By cruisesLink = By.cssSelector("ul>li:nth-child(6)");

    // Calendar pickers - these share the same id for all travel options
    private By firstDate = By.id("d1-btn");
    private By finalDate  = By.id("d2-btn");
    private By firstDayOfMonth = By.cssSelector("[data-day='1']");
    private By lastDayOfMonth = By.cssSelector("[data-day='13']");
    private By dateDoneButton = By.cssSelector("[data-stid='apply-date-picker']");
    private By flightsCheckIn = By.xpath("(//button[@id='d1-btn'])[2]");
    private By flightsCheckInArrow = By.xpath("//button[contains(@data-stid, 'date-picker-paging')][2]");
    private By confirmCheckInDate = By.cssSelector("[data-stid='apply-date-picker'");

    // Input selectors - Stays
    private By staysDestination = By.id("location-field-destination-input");
    private By staysDestinationInput = By.cssSelector("[data-stid='location-field-destination-menu-trigger']");
    private By firstResultDestination = By.cssSelector("[data-stid='location-field-destination-result-item-button']");
    private By staysAddFlight = By.id("add-flight-switch");

    // Input selectors - Flights
    private By flightsOrigin = By.id("location-field-leg1-origin-menu");
    private By flightsOriginInput = By.id("location-field-leg1-origin");
    private By flightsDestination = By.id("location-field-leg1-destination-menu");
    private By flightsDestinationInput = By.id("location-field-leg1-destination");
    private By flightsNextMonthArrow = By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]");
    private By addStayToFlight = By.id("add-hotel-checkbox");

    // Input selectors - Packages
    private By packagesOrigin = By.id("location-field-origin-menu");
    private By packagesDestination = By.id("location-field-destination-menu");

    // Input Selectors - Cruises
    private By cruiseDestination = By.id("cruise-destination");

    // Suggested result selectors - Flights
    private By flightsOriginSuggestedResult = By.cssSelector("[data-stid='location-field-leg1-origin-result-item-button']:first-child");
    private By flightsDestinationSuggestedResult = By.cssSelector("[data-stid='location-field-leg1-destination-result-item-button']:first-child");


    // Search buttons
    private By flightsSearchButton = By.cssSelector("button[data-testid='submit-button']");

    private By firstStaysDateError = By.id("d1-error");

    // Constructor - uses the driver that has launched the browser
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // this.wait = new WebDriverWait(driver, 30);
    }

    // click methods

    public void clickFlightsLink() {
        clickElement(flightsLink);
    }

    public void clickFlightsPlusHotel() {
        clickFlightsLink();
        driver.findElement(addStayToFlight).click();
    }

    // sendKeys methods - Stays
    // TODO Implement wait so result can be searched for
    public void setStaysDestination(String destination) {
        clickElement(staysLink);
        driver.findElement(staysDestinationInput).sendKeys(destination);
        clickElement(firstResultDestination);
    }


    // sendKeys methods - Flights
    public void setFlightsOrigin(String origin) {
        clickElement(flightsOrigin);
        driver.findElement(flightsOriginInput).sendKeys(origin);
        clickElement(flightsOriginSuggestedResult);
    }

    public void setFlightsDestination(String destination) {
        clickElement(flightsDestination);
        driver.findElement(flightsDestinationInput).sendKeys(destination);
        clickElement(flightsDestinationSuggestedResult);
    }

    public void setCruiseDestination() {
        clickElement(cruisesLink);
        WebElement sortDropdown = driver.findElement(cruiseDestination);
        Select select = new Select(sortDropdown);
        select.selectByValue("europe");
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

    public void setFlightsStayDate() {
        clickElement(flightsCheckIn);
        for(int i = 0; i < 4; i++) {
            clickElement(flightsCheckInArrow);
        }
        clickElement(firstDayOfMonth);
        clickElement(lastDayOfMonth);
        clickElement(confirmCheckInDate);
    }

    // Page handlers - Flights
    public FlightsPage clickFlightsSearch() {
        clickElement(flightsSearchButton);
        return new FlightsPage(driver);
    }

    public HotelSearchPage clickFlightsPlusHotelSearch() {
        clickElement(flightsSearchButton);
        return new HotelSearchPage(driver);
    }

    public CruiseSearchPage cruiseSearchPage() {
        clickElement(flightsSearchButton);
        return new CruiseSearchPage(driver);
    }

    public boolean staysDateErrorIsPresent() {
        return driver.findElement(firstStaysDateError).getText().contains("Your check-in date must fall within your departing and returning dates");
    }
}
