package reservation;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HotelSearchPage;

@Listeners(listener.Listener.class)

public class HotelSearchTests extends BaseTests {
    @Test
    public void testHotelSearch()  {
        // * These tests correspond to exercise 3

        homePage.setStaysDestination("Montevideo, Uruguay");

        // * Tests on results page
        HotelSearchPage hotelSearchPage = homePage.clickFlightsPlusHotelSearch();

        Assert.assertTrue(hotelSearchPage.sponsoredResultsArePresent());

        Assert.assertTrue(hotelSearchPage.discountOptionIsPresent());
    }
}
