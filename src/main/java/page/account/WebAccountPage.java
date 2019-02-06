package page.account;

import org.openqa.selenium.WebDriver;

public class WebAccountPage extends AccountPage{

	public WebAccountPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public boolean isPageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickOnSignInButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean errorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
