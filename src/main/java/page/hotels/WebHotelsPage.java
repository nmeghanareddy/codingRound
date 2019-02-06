package page.hotels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import common.Constants;

public class WebHotelsPage extends HotelsPage {

	public WebHotelsPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(className = "searchForm")
	private WebElement formElement;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "CheckInDate")
	private WebElement checkInDate;

	@FindBy(id = "CheckOutDate")
	private WebElement checkOutDate;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchHotelsButton;

	@FindBy(className = "searchSummary")
	private WebElement searchResults;

	@Override
	public boolean isPageDisplayed() {
		boolean isDisplayed = false;
		try {
			waitForPageLoad(webDriver, 20, 5);
			String url = webDriver.getCurrentUrl();
			if (url.equals(Constants.HOTELS_PAGE_URL)) {
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
			selectLocality();
			selectCheckInDate();
			selectCheckOutDate();
			selectTravellers();
			clickOnSearchHotelsButton();
		} catch (Exception ex) {
			System.out.println("Exception in enterDetails");
			ex.printStackTrace();
		}
	}

	private void clickOnSearchHotelsButton() {
		try {
			if (searchHotelsButton.isDisplayed()) {
				searchHotelsButton.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in clickOnSearchHotelsButton");
			ex.printStackTrace();
		}
	}

	private void selectTravellers() {
		try {
			if (travellerSelection.isDisplayed()) {
				travellerSelection.click();
				Select select = new Select(travellerSelection);
				select.selectByValue("4");
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectTravellers");
			ex.printStackTrace();
		}
	}

	private void selectCheckOutDate() {
		try {
			if (checkOutDate.isDisplayed()) {
				checkOutDate.click();

				waitFor(2000);
				WebElement date = webDriver.findElement(By
						.cssSelector(".ui-state-default.ui-state-active"));
				date.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectCheckOutDate");
			ex.printStackTrace();
		}
	}

	private void selectCheckInDate() {
		try {
			if (checkInDate.isDisplayed()) {
				checkInDate.click();

				waitFor(2000);
				WebElement date = webDriver
						.findElement(By
								.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
				date.click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectCheckInDate");
			ex.printStackTrace();
		}
	}

	private void selectLocality() {
		try {
			if (localityTextBox.isDisplayed()) {
				localityTextBox.click();
				localityTextBox.sendKeys("Indiranagar, Bangalore");

				waitFor(5000);
				List<WebElement> localityOptions = webDriver.findElement(
						By.id("ui-id-1")).findElements(By.className("list"));
				localityOptions.get(0).click();
			}
		} catch (Exception ex) {
			System.out.println("Exception in selectLocality");
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
