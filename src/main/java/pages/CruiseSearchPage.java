package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CruiseSearchPage extends BasePage {

    private WebDriver driver;

    private By fifteenNightsFilter = By.id("length-15-ember874-label");
    private By loaderMessage = By.id("uitk-live-announce");
    private By continueBtn = By.cssSelector(".select-sailing-button");

    public CruiseSearchPage(WebDriver driver) {
        super(driver);
    }

    public void filterOverFifteenNights() {
        clickElement(fifteenNightsFilter);
        waitForAnnouncementText(loaderMessage, "Page update is complete");
    }

    public CruiseDetailsPage selectFirstCruise() {
        clickElement(continueBtn);
        switchToNewTab();
        return new CruiseDetailsPage(driver);
    }

}
