package page.flights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.Constants;

public class WebFlightsPage extends FlightsPage {

	public WebFlightsPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(id = "SearchForm")
	private WebElement formElement;

	@FindBy(id = "OneWay")
	private WebElement tripType;

	@FindBy(id = "FromTag")
	private WebElement fromText;

	@FindBy(id = "ToTag")
	private WebElement toText;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	private WebElement datePicker;

	@FindBy(id = "SearchBtn")
	private WebElement searchFlightsButton;

	@FindBy(className = "searchSummary")
	private WebElement searchResults;

	@Override
	public boolean isPageDisplayed() {
		boolean isDisplayed = false;
		try {
			waitForPageLoad(webDriver, 20, 5);
			String url = webDriver.getCurrentUrl();
			if (url.equals(Constants.FLIGHTS_PAGE_URL)) {
				if (formElement.isDisplayed())
					isDisplayed = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception in isPageDisplayed");
			ex.printStackTrace();
		}
		return isDisplayed;
	}

	@Override
	public void enterDetails() {
		try {
			waitFor(5000);
			selectTripType();
			selectSource();
			selectDestination();
			selectDate();
			clickOnSearchFlightsButton();
		} catch (Exception ex) {
			System.out.println("Exception in enterDetails");
			ex.printStackTrace();
		}
	}

	private void clickOnSearchFlightsButton() {
		try {
			if (searchFlightsButton.isDisplayed()) {
				searchFlightsButton.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnSearchFlightsButton");
			ex.printStackTrace();
		}
	}

	private void selectDate() {
		try {
			if (datePicker.isDisplayed()) {
				datePicker.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectDate");
			ex.printStackTrace();
		}
	}

	private void selectDestination() {
		try {
			if (toText.isDisplayed()) {
				toText.clear();
				toText.sendKeys("Delhi");

				waitFor(5000);
				List<WebElement> destinationOptions = webDriver.findElement(
						By.id("ui-id-2")).findElements(By.tagName("li"));
				destinationOptions.get(0).click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectDestination");
			ex.printStackTrace();
		}
	}

	private void selectSource() {
		try {
			if (fromText.isDisplayed()) {
				fromText.clear();
				fromText.sendKeys("Bangalore");

				waitFor(5000);
				List<WebElement> originOptions = webDriver.findElement(
						By.id("ui-id-1")).findElements(By.tagName("li"));
				originOptions.get(0).click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectSource");
			ex.printStackTrace();
		}
	}

	private void selectTripType() {
		try {
			if (tripType.isDisplayed()) {
				tripType.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectTripType");
			ex.printStackTrace();
		}
	}

	@Override
	public boolean isSearchResultsDisplayed() {
		boolean isDisplayed = false;
		try {
			if (searchResults.isDisplayed()) {
				isDisplayed = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception in isSearchResultsDisplayed");
			ex.printStackTrace();
		}
		return isDisplayed;
	}

}
