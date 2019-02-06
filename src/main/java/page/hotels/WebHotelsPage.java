package page.hotels;

import org.openqa.selenium.WebDriver;

public class WebHotelsPage extends HotelsPage{

	public WebHotelsPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public boolean isPageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enterDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSearchResultsDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
