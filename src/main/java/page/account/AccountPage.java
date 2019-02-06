package page.account;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;

public abstract class AccountPage extends AbstractPage {

	public AccountPage(WebDriver webDriver) {
		super(webDriver);
	}

	public abstract boolean isPageDisplayed();

	public abstract void clickOnSignInButton();

	public abstract boolean errorMessageDisplayed();
}
