package page.flights;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;

public abstract class FlightsPage extends AbstractPage{

	public FlightsPage(WebDriver webDriver) {
		super(webDriver);
	}

	public abstract boolean isPageDisplayed();
	
	public abstract void enterDetails();

	public abstract boolean isSearchResultsDisplayed();
}
