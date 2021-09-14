package reservation;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.Listener.class)

public class DateErrorTests extends BaseTests {
    @Test
    public void testDateErrors()  {
        // * These tests correspond to exercise 4

        homePage.clickFlightsPlusHotel();
        homePage.setFlightsOrigin("LAS");
        homePage.setFlightsDestination("LAX");
        homePage.setFlightsDepartureDate();
        homePage.clickFlightsPlusHotelSearch();

        Assert.assertTrue(homePage.staysDateErrorIsPresent());
    }
}
