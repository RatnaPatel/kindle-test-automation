package ca.amazon.ta.common.test;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import ca.amazon.ta.common.config.Configuration;
import ca.amazon.ta.common.util.Constant;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class BaseTest {

	protected static URL gridHubUrl = null;
	protected static String baseUrl;
	protected static Capabilities capabilities;

	protected WebDriver driver;

	/*
	 * Setting grid url and capabilities before execution of tests from test suit
	 */
	@BeforeSuite
	public void initTestSuite() throws IOException {
		Configuration config = Configuration.getInstance();
		if (config.hasProperty(Constant.GRID_URL) && !"".equals(config.getProperty(Constant.GRID_URL))) {
			gridHubUrl = new URL(config.getProperty(Constant.GRID_URL));
		}
		capabilities = config.getCapabilities();
	}

	/*
	 * Creating instance of web driver with given capabilities
	 */
	@BeforeClass
	public void initWebDriver() {
		driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
	}

	/*
	 * It must executes after completion of test run Quits all web drivers and
	 * emptying web driver pool.
	 */
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		WebDriverPool.DEFAULT.dismissAll();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
