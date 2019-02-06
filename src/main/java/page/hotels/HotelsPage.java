package page.hotels;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;

public abstract class HotelsPage extends AbstractPage {

	public HotelsPage(WebDriver webDriver) {
		super(webDriver);
	}

	public abstract boolean isPageDisplayed();

	public abstract void enterDetails();

	public abstract boolean isSearchResultsDisplayed();
}
