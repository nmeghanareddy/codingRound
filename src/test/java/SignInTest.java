import org.testng.Assert;
import org.testng.annotations.Test;

import common.BrowserDriver;

public class SignInTest extends BrowserDriver{

	@Test
	public void validateSignIn() {
		if (homePage.isPageDisplayed()) {
			homePage.clickOnYourTrips();
			if (accountPage.isPageDisplayed()) {
				accountPage.clickOnSignInButton();
				if (!accountPage.errorMessageDisplayed()) {
					Assert.assertTrue(false,
							"Error Message is not displayed for missing Sign In details");
				}
			} else {
				Assert.assertTrue(false,
						"Sign In Form is not displayed to enter credentials");
			}
		} else {
			Assert.assertTrue(false, "Home Page is not displayed to Sign In");
		}
	}
}
