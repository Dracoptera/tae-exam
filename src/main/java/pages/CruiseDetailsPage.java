package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CruiseDetailsPage extends BasePage {

    private WebDriver driver;

    private By cruiseName = By.id("redirectLink");
    private By cruiseTitle = By.cssSelector(".title-on-ship-image");

    private By announcement = By.id("uitk-live-announce");

    public CruiseDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void waitForPageToLoad(){
        waitForAnnouncementText(announcement, "Your cabin type search is completed");
    }

    public boolean cruiseNameIsPresent() {
        return !driver.findElement(cruiseName).getText().equals("");
    }

    public boolean cruiseTitleIsPresent() {
        return !driver.findElement(cruiseTitle).getText().equals("");
    }
}
