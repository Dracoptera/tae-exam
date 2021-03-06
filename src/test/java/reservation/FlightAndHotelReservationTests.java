package reservation;

import base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import static org.testng.Assert.assertTrue;

@Listeners(listener.Listener.class)

public class FlightAndHotelReservationTests extends BaseTests {

    // * These tests correspond to exercise 2

    @Test
    public void testReservationWithHotel()  {
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

        // * Checkout tests
        FlightCheckoutPage flightCheckoutPage = flightDetailsPage.clickFinalDetails();

        flightCheckoutPage.waitForPageToLoad();

        // Choose at least 5 validations to be performed
        // TODO Double check locators for these methods. The page seems to be a bit different.
        assertTrue(flightCheckoutPage.insuranceIsPresent());
        assertTrue(flightCheckoutPage.paymentIsPresent());
    }
}
