package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsPage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Page locators
    private By innerAnnouncement = By.id("uitk-live-announce");
    private By sortBySelector = By.id("listings-sort");

    private By loadingAnimation = By.id("el_BOCLP6pw6");

    // Individual flight locators
    private By flightCard = By.cssSelector("ul[data-test-id='listings'] li[data-test-id='offer-listing']");
    private By thirdFlightCard = By.cssSelector("ul[data-test-id='listings'] li[data-test-id='offer-listing']:nth-child(3)");
    private By flightDuration = By.cssSelector("div[data-test-id='journey-duration']");
    private By showMoreButton = By.name("showMoreButton");
    private By continueBtn = By.cssSelector("button[data-test-id='select-button']");

    // Hotels modal
    private By addHotelModal = By.cssSelector("[data-test-id='xSellHotelForcedChoice']");
    private By closeModalButton = By.cssSelector("[data-test-id='forcedChoiceNoThanks']");

    public FlightsPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void closeModal() {
        if (driver.findElement(addHotelModal).isDisplayed()) {
            clickElement(closeModalButton);
        }
    }

    public FlightDetailsPage proceedToFlightDetails() {
        clickElement(flightCard);
        clickElement(continueBtn);
        waitForAnnouncementText(innerAnnouncement, "Results now sorted by Price (Lowest)");
        clickElement(thirdFlightCard);
        clickElement(continueBtn);
        closeModal();
        return new FlightDetailsPage(driver);
    }

    /**
     * Returns a list containing the flight duration in minutes. The original format for each WebElement's text is: 'Xh Xm (Nonstop)'
     * @param flightDurationList a list containing all the WebElements to be converted. These are the "Flight Duration" elements present on every result.
     * @return a list containing all the elements in their equivalent in minutes
     */
    public List<Integer> flightDurationToInteger(List<WebElement> flightDurationList) {
        ArrayList<Integer> durationsInMinutes = new ArrayList<>();

        for(WebElement flightDuration: flightDurationList) {
            String[] duration = flightDuration.getText().split(" ");
            int hours = Integer.parseInt(duration[0].substring(0, duration[0].indexOf('h')));
            int minutes = Integer.parseInt(duration[1].substring(0, duration[1].indexOf('m')));
            int totalDuration = ((hours * 60) + minutes);
            durationsInMinutes.add(totalDuration);
        }

        return durationsInMinutes;
    }

    public void sortByShortest() {
        WebElement sortDropdown = driver.findElement(sortBySelector);
        Select select = new Select(sortDropdown);
        select.selectByValue("DURATION_INCREASING");
        waitForAnnouncementText(innerAnnouncement, "Results now sorted by Duration (Shortest)");
    }

    public boolean correctlySortedByShortest() {
        sortByShortest();
        List<WebElement> sortedByShortestDurations = getWebElementList(flightDuration);
        List<Integer> durationInMinutes = flightDurationToInteger(sortedByShortestDurations);

        return durationInMinutes.stream().sorted().collect(Collectors.toList()).equals(durationInMinutes);
    }

    public boolean sortBySelectorIsPresent() {
        waitForElementToDisappear(loadingAnimation);
        return driver.findElement(sortBySelector).isDisplayed();
    }

    public boolean sortByOptionsArePresent() {
        Select select = new Select(driver.findElement(sortBySelector));
        List<WebElement> allOptions = select.getOptions();

        for(WebElement option : allOptions) {
            if(!(option.getText().contains("Price")
                    || option.getText().contains("Departure")
                    || option.getText().contains("Arrival")
                    || option.getText().contains("Duration"))) {
                return false;
            }
        }
        return true;
    }

    public boolean allFlightsCanBeSelected() {
        waitForElementToBeVisible(showMoreButton);
        List<WebElement> flights = getWebElementList(flightCard);

        for(WebElement flight: flights) {
            flight.click();
            WebElement closeButton = driver.findElement(By.cssSelector("button[data-icon='tool-close']"));
            waitForElementToBeClickable(continueBtn);
            if(!driver.findElement(continueBtn).isDisplayed()) {
                return false;
            }
            closeButton.click();
        }
        return true;
    }

    public boolean flightDurationIsPresent() {
        waitForElementToBeVisible(showMoreButton);
        List<WebElement> flights = driver.findElements(flightCard);

        for(WebElement flight:flights) {
            if(!flight.findElement(flightDuration).isDisplayed()) {
                return false;
            }
        }
        return true;
    }

}
