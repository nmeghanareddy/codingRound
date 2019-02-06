package page.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebAccountPage extends AccountPage {

	public WebAccountPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(id = "modal_window")
	private WebElement frameElement;

	@FindBy(id = "email")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "signInButton")
	private WebElement signInButton;

	@FindBy(id = "errors1")
	private WebElement errorMessage;

	@Override
	public boolean isPageDisplayed() {
		boolean isDisplayed = false;
		try {
			waitFor(10000);
			webDriver.switchTo().frame(frameElement);
			if (username.isDisplayed() && password.isDisplayed()
					&& signInButton.isDisplayed()) {
				isDisplayed = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception in isPageDisplayed");
			ex.printStackTrace();
		}
		return isDisplayed;
	}

	@Override
	public void clickOnSignInButton() {
		try {
			if (signInButton.isDisplayed()) {
				signInButton.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnSignInButton");
			ex.printStackTrace();
		}
	}

	@Override
	public boolean errorMessageDisplayed() {
		boolean isDisplayed = false;
		try {
			if (errorMessage.isDisplayed()) {
				isDisplayed = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception in errorMessageDisplayed");
			ex.printStackTrace();
		}
		return isDisplayed;
	}
}
