package reservation;

import base.BaseTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class ReservationTests extends BaseTests {

    // TODO Replace hardcode with params
    @Test
    public void testOrderByFilter() {
        homePage.clickFlightsLink();
        homePage.setFlightsOrigin("LAS");
        homePage.setFlightsDestination("LAX");
        homePage.setFlightsDepartureDate();
        FlightsPage flightsPage = homePage.clickFlightsSearch();
    }

}
