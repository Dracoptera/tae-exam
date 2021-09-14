package reservation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;
import pages.FlightDetailsPage;
import static org.testng.Assert.assertTrue;

public class FlightReservationTests extends BaseTests {

    // * These tests correspond to exercise 1

    // TODO Replace hardcode with params

    @Test
    public void verifyResultsPage() throws InterruptedException {
        homePage.clickFlightsLink();
        homePage.setFlightsOrigin("LAS");
        homePage.setFlightsDestination("LAX");
        homePage.setFlightsDepartureDate();

        // * Tests on results page
        FlightsPage flightsPage = homePage.clickFlightsSearch();

        // Assertion - There is a box that allow you to order by Price, Departure, Arrival and Duration.
        assertTrue(flightsPage.sortBySelectorIsPresent());
        assertTrue(flightsPage.sortByOptionsArePresent());

        // Assertion - The select button is present on every result
        assertTrue(flightsPage.allFlightsCanBeSelected());

        // Assertion - Flight duration is present on every result
        assertTrue(flightsPage.flightDurationIsPresent());

        // Assertion - Sort by duration > shorter. Verify the list was correctly sorted.
        assertTrue(flightsPage.correctlySortedByShortest());

        // * Booking tests
        FlightDetailsPage flightDetailsPage = flightsPage.proceedToFlightDetails();

        flightDetailsPage.waitForPageToLoad();
        // Assertion - Trip total price is present
        assertTrue(flightDetailsPage.tripTotalIsPresent());

        // Assertion - Departure and return information is present
        assertTrue(flightDetailsPage.departureAndReturnInfoArePresent());

        // Assertion - Price guarantee text is present - [This element is no longer present]

        // * Checkout tests
        FlightCheckoutPage flightCheckoutPage = flightDetailsPage.clickCheckout();

        flightCheckoutPage.waitForPageToLoad();
        // Choose at least 5 validations to be performed
        assertTrue(flightCheckoutPage.travellerInfoIsPresent());
        assertTrue(flightCheckoutPage.insuranceIsPresent());
        assertTrue(flightCheckoutPage.paymentIsPresent());
    }

}
