package experimental;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class ExperimentalTests extends BaseTests {

    @Test
    public void testDetailsPage()  {
        homePage.setStaysDestination("Montevideo, Uruguay");

        // * Tests on results page
        HotelSearchPage hotelSearchPage = homePage.clickFlightsPlusHotelSearch();

        Assert.assertTrue(hotelSearchPage.sponsoredResultsArePresent());

        Assert.assertTrue(hotelSearchPage.discountOptionIsPresent());
    }
}
