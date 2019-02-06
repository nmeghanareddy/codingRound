package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import page.account.AccountPage;
import page.account.WebAccountPage;
import page.flights.FlightsPage;
import page.flights.WebFlightsPage;
import page.hotels.HotelsPage;
import page.hotels.WebHotelsPage;

import com.sun.javafx.PlatformUtil;

public class BrowserDriver {
	public static WebDriver webDriver;
	
	public AccountPage accountPage = null;
	public FlightsPage flightsPage = null;
	public HotelsPage hotelsPage = null;
	
	@BeforeClass
	public void initDriver() {
		setDriverPath();
		webDriver = new ChromeDriver();

		webDriver.get(Constants.WEBSITE_URL);

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		accountPage = new WebAccountPage(webDriver);
		flightsPage = new WebFlightsPage(webDriver);
		hotelsPage = new WebHotelsPage(webDriver);
	}

	@AfterClass
	public void quitDriver() throws Exception {
		if (webDriver != null) {
			webDriver.quit();
		}
		accountPage = null;
		flightsPage = null;
		hotelsPage = null;
	}

	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}
}
