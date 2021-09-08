package experimental;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

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

        HotelDetailsPage hotelDetailsPage = hotelSearchPage.clickHotelAboveRating(3);

        FlightsPage flightsPage = hotelDetailsPage.clickFirstRoom();

        FlightDetailsPage flightDetailsPage = flightsPage.proceedToFlightWithStays();

        flightDetailsPage.addCar();
    }
}
