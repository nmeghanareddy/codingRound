import org.testng.Assert;
import org.testng.annotations.Test;

import common.BrowserDriver;

public class HotelBookingTest extends BrowserDriver{
	
	@Test
	public void verifySearchResultsDisplayed() {
		if (hotelsPage.isPageDisplayed()) {
			hotelsPage.enterDetails();
			if (!hotelsPage.isSearchResultsDisplayed()) {
				Assert.assertTrue(false,
						"Search Results are not displayed with selected details");
			}
		} else {
			Assert.assertTrue(false,
					"Search Hotels Page is not displayed for Hotel bookings");
		}
	}
}
