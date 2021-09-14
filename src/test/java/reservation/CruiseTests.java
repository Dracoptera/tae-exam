package reservation;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruiseDetailsPage;
import pages.CruiseSearchPage;

public class CruiseTests extends BaseTests {
    @Test
    public void testCruiseDetails()  {
        homePage.setCruiseDestination();

        CruiseSearchPage cruiseSearchPage = homePage.cruiseSearchPage();

        cruiseSearchPage.filterOverFifteenNights();

        CruiseDetailsPage cruiseDetailsPage = cruiseSearchPage.selectFirstCruise();

        cruiseDetailsPage.waitForPageToLoad();

        Assert.assertTrue(cruiseDetailsPage.cruiseNameIsPresent());
        Assert.assertTrue(cruiseDetailsPage.cruiseTitleIsPresent());
    }
}
