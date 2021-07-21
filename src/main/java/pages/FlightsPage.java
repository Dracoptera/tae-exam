package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightsPage {
    private WebDriver driver;

    private WebDriverWait wait;

    private By sortBySelector = By.id("listings-sort");
    private By flightsDeckList = By.id("search-results");
    // private By flightCard = By.cssSelector("ul[data-test-id='listings'] li > div");
    // private By flightCard = By.cssSelector("button.uitk-card-link[data-test-id='select-link']");
    private By flightCard = By.cssSelector("ul[data-test-id='listings'] li[data-test-id='offer-listing']");
    private By flightDuration = By.cssSelector("div[data-test-id='journey-duration']");
    private By loadingAnimation = By.id("el_BOCLP6pw6");

    private By listLoadedText = By.cssSelector("[data-test-id=\"listing-header-bar\"] div.uitk-text");
    private By showMoreButton = By.name("showMoreButton");

    private By continueBtn = By.cssSelector("button[data-test-id='select-button']");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
    }

    public boolean sortBySelectorIsPresent() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingAnimation));
        return driver.findElement(sortBySelector).isDisplayed();
    }

    public boolean sortByOptionsArePresent() {
        WebElement sortDropdown = driver.findElement(By.id("listings-sort"));
        Select select = new Select(sortDropdown);
        List<WebElement> allOptions = select.getOptions();
        boolean present = false;

        for(WebElement option : allOptions) {
            if(option.getText().contains("Price")
                    || option.getText().contains("Departure")
                    || option.getText().contains("Arrival")
                    || option.getText().contains("Duration")) {
                present = true;
            }
        }

        return present;
    }

    // TODO VERIFY SELECTOR!
    public boolean allFlightsCanBeSelected() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(showMoreButton));
        List<WebElement> flights = driver.findElements(flightCard);
        System.out.println(flights.size());

        for(WebElement flight: flights) {
            flight.click();
            WebElement closeButton = driver.findElement(By.cssSelector("button[data-icon='tool-close']"));
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[tabindex='-1']")));
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
            if(!driver.findElement(continueBtn).isDisplayed()) {
                return false;
            }
            closeButton.click();
        }
        return true;
    }

    public boolean flightDurationIsPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(showMoreButton));
        List<WebElement> flights = driver.findElements(flightCard);
        // WebElement flightDuration = driver.findElement(By.cssSelector("div[data-test-id='journey-duration']"));

        System.out.println(flights.size());
        for(WebElement flight:flights) {
            System.out.println(flight.findElement(flightDuration).getText());
            if(!flight.findElement(flightDuration).isDisplayed()) {
                return false;
            }
        }

        return true;
    }
}
