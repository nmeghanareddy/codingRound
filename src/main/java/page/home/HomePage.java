package page.home;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;

public abstract class HomePage extends AbstractPage {

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public abstract boolean isPageDisplayed();

	public abstract void clickOnFlights();

	public abstract void clickOnHotels();

	public abstract void clickOnYourTrips();
}
