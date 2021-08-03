package experimental;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightCheckoutPage;
import pages.FlightDetailsPage;
import pages.FlightsPage;
import pages.HotelSearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExperimentalTests extends BaseTests {

    @Test
    public void testDetailsPage()  {
        homePage.clickFlightsPlusHotel();
        homePage.setFlightsOrigin("LAS");
        homePage.setFlightsDestination("LAX");
        homePage.setFlightsDepartureDate();
        homePage.setFlightsStayDate();

        // * Tests on results page
        HotelSearchPage hotelSearchPage = homePage.clickFlightsPlusHotelSearch();

        hotelSearchPage.sortByPrice();

        assertTrue(hotelSearchPage.correctlySortedByPrice());

    }
}
