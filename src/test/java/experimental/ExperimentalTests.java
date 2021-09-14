package experimental;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ExperimentalTests extends BaseTests {

    @Test
    public void testDetailsPage()  {
        homePage.setCruiseDestination();

        CruiseSearchPage cruiseSearchPage = homePage.cruiseSearchPage();

        cruiseSearchPage.filterOverFifteenNights();

        CruiseDetailsPage cruiseDetailsPage = cruiseSearchPage.selectFirstCruise();

        Assert.assertTrue(cruiseDetailsPage.cruiseNameIsPresent());
        Assert.assertTrue(cruiseDetailsPage.cruiseTitleIsPresent());
    }
}
