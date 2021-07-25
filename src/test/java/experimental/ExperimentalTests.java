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

        // TODO FIX org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.cssSelector: div table.experimental-pricing (tried for 60 second(s) with 500 milliseconds interval)
        flightDetailsPage.waitForPageToLoad();
        assertTrue(flightDetailsPage.tripTotalHeader().contains("Trip total"), "Error with name");
    }
}
