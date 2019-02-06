package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AbstractPage {
	public WebDriver webDriver;

	public AbstractPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void waitForPageLoad(WebDriver webDriver, long timeout,
			long pollTimeout) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pollTimeout, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				return ((JavascriptExecutor) webDriver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		wait.until(pageLoadCondition);
	}

	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
