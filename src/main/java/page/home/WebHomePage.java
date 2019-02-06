package page.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.Constants;

public class WebHomePage extends HomePage {

	public WebHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(className = "cleartripLogo")
	private WebElement logo;

	@FindBy(linkText = "Flights")
	private WebElement flightsLink;

	@FindBy(linkText = "Hotels")
	private WebElement hotelsLink;

	@FindBy(linkText = "Your trips")
	private WebElement yourTripsLink;

	@FindBy(id = "SignIn")
	private WebElement signInButton;

	@Override
	public boolean isPageDisplayed() {
		boolean isDisplayed = false;
		try {
			waitForPageLoad(webDriver, 20, 5);
			String url = webDriver.getCurrentUrl();
			if (url.equalsIgnoreCase(Constants.WEBSITE_URL)) {
				if (logo.isDisplayed())
					isDisplayed = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception in isPageDisplayed");
			ex.printStackTrace();
		}
		return isDisplayed;
	}

	@Override
	public void clickOnFlights() {
		try {
			if (flightsLink.isDisplayed()) {
				flightsLink.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnFlights");
			ex.printStackTrace();
		}
	}

	@Override
	public void clickOnHotels() {
		try {
			if (hotelsLink.isDisplayed()) {
				hotelsLink.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnHotels");
			ex.printStackTrace();
		}
	}

	@Override
	public void clickOnYourTrips() {
		try {
			if (yourTripsLink.isDisplayed()) {
				yourTripsLink.click();
				clickOnSignInButton();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnYourTrips");
			ex.printStackTrace();
		}
	}

	private void clickOnSignInButton() {
		try {
			if (signInButton.isDisplayed()) {
				signInButton.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnSignInButton");
			ex.printStackTrace();
		}
	}

}
