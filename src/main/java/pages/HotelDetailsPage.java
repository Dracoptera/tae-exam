package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HotelDetailsPage extends BasePage {
    private WebDriver driver;

    private By firstRoom = By.cssSelector("[data-stid='submit-hotel-reserve']");

    public HotelDetailsPage(WebDriver driver) {
        super(driver);
    }

    public FlightsPage clickFirstRoom() {
        for(int i = 0; i <= 15; i++) {
            getDriver().findElement(By.tagName("body")).sendKeys(Keys.DOWN);
        }
        clickElement(firstRoom);
        return new FlightsPage(driver);
    }
}
