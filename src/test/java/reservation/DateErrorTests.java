package reservation;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateErrorTests extends BaseTests {
    @Test
    public void testDateErrors()  {
        homePage.clickFlightsPlusHotel();
        homePage.setFlightsOrigin("LAS");
        homePage.setFlightsDestination("LAX");
        homePage.setFlightsDepartureDate();
        homePage.clickFlightsPlusHotelSearch();

        Assert.assertTrue(homePage.staysDateErrorIsPresent());
    }
}