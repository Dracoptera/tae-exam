package reservation;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FlightDetailsPage;
import pages.FlightDetailsPage;
import pages.FlightsPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReservationTests extends BaseTests {

    // TODO Replace hardcode with params

    @Test
    public void verifyResultsPage() {
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
        // assertTrue(flightsPage.allFlightsCanBeSelected());

        // Assertion - Flight duration is present on every result
        assertTrue(flightsPage.flightDurationIsPresent());

        // Assertion - Sort by duration > shorter. Verify the list was correctly sorted.
        assertTrue(flightsPage.correctlySortedByShortest());

        // * Booking tests
        // TODO Handle possible hotel modal
        FlightDetailsPage flightDetailsPage = flightsPage.proceedToFlightDetails();

        // Assertion - Trip total price is present
        assertTrue(flightDetailsPage.tripTotalIsPresent());
        // Assertion - Departure and return information is present
        // Assertion - Price guarantee text is present

        // * Checkout tests
        // Choose at least 5 validations to be performed
    }

}
