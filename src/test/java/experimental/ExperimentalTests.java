package experimental;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightDetailsPage;
import pages.FlightsPage;

import static org.testng.Assert.assertTrue;

public class ExperimentalTests extends BaseTests {

    @Test
    public void testDetailsPage() {
        homePage.clickFlightsLink();
        homePage.setFlightsOrigin("LAS");
        homePage.setFlightsDestination("LAX");
        homePage.setFlightsDepartureDate();

        // * Tests on results page
        FlightsPage flightsPage = homePage.clickFlightsSearch();

        FlightDetailsPage flightDetailsPage = flightsPage.proceedToFlightDetails();

        assertTrue(flightDetailsPage.tripTotalIsPresent());
    }
}
