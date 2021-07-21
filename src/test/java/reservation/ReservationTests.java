package reservation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static org.testng.Assert.assertEquals;

public class ReservationTests extends BaseTests {

    // TODO Replace hardcode with params

    @Test
    // Assertion - There is a box that allow you to order by Price, Departure, Arrival and Duration.
    // Assertion - The select button is present on every result
    // Assertion - Flight duration is present on every result
    // Assertion -  The flight detail and baggage fees is present on every result
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
        assertTrue(flightsPage.allFlightsCanBeSelected());

        // Assertion - Flight duration is present on every result
        assertTrue(flightsPage.flightDurationIsPresent());
    }

}
