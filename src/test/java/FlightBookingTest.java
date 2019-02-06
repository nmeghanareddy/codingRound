import org.testng.Assert;
import org.testng.annotations.Test;

import common.BrowserDriver;

public class FlightBookingTest extends BrowserDriver{
	
	@Test
	public void verifySearchResultsDisplayed() {
		if (flightsPage.isPageDisplayed()) {
			flightsPage.enterDetails();
			if (!flightsPage.isSearchResultsDisplayed()) {
				Assert.assertTrue(false,
						"Search results are not displayed for selected details");
			}
		} else {
			Assert.assertTrue(false,
					"Search for Flights Page is not displayed for Flight bookings");
		}
	}
}
