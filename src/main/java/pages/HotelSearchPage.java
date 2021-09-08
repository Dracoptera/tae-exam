package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchPage extends BasePage {
    private WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By innerAnnouncement = By.id("uitk-live-announce");
    private By sortBySelector = By.id("sort");
    private By hotelInformationCard = By.cssSelector("[data-stid='open-hotel-information']");

    private By priceText = By.cssSelector("[data-stid='price-lockup-text']");
    private By thumbnailSkeleton = By.cssSelector("div.uitk-skeleton-image");
    private By hotelRating = By.cssSelector("[data-stid='content-hotel-reviews-rating']");

    public void sortByPrice() {
        WebElement sortDropdown = driver.findElement(sortBySelector);
        Select select = new Select(sortDropdown);
        select.selectByValue("PRICE_LOW_TO_HIGH");
        waitForElementToBeVisible(hotelInformationCard);
        waitForAnnouncementText(innerAnnouncement, "Results updated,sorted by Price,filtered by Los Angeles (and vicinity)");
    }

    public boolean correctlySortedByPrice() {
        // sortByPrice();
        waitForElementToDisappear(thumbnailSkeleton);
        List<WebElement> allPricesInText = getWebElementList(priceText);
        List<Integer> allPrices = pricesList(allPricesInText);

        return allPrices.stream().sorted().collect(Collectors.toList()).equals(allPrices);
    }

    public List<Integer> pricesList(List<WebElement> priceList) {
        ArrayList<Integer> allPrices = new ArrayList<>();

        for(WebElement price: priceList) {
            int num = Integer.parseInt(extractDigits(price.getText()));
            allPrices.add(num);
        }
        return allPrices;
    }

    // TODO Fix method. It should return first result with at least 3 stars ONLY
    public WebElement minimumRated(int minRating) {
        List<WebElement> allRatings = getWebElementList(hotelRating);
        for(WebElement rating: allRatings) {
            if ((extractDigits(rating.getText()).charAt(0)) >= minRating) {
                return rating;
            }
        }
        return allRatings.get(0);
    }

    public HotelDetailsPage clickHotelAboveRating(int stars) {
        Actions actions = new Actions(driver);
        actions.moveToElement(minimumRated(stars)).click().perform();
        switchToNewTab();
        return new HotelDetailsPage(driver);
    }
}
