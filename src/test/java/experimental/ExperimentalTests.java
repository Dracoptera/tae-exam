package experimental;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class ExperimentalTests extends BaseTests {

    // TODO Rename Tests

    @Test
    public void testDetailsPage()  {
        homePage.setCruiseDestination();

        CruiseSearchPage cruiseSearchPage = homePage.cruiseSearchPage();
    }
}
