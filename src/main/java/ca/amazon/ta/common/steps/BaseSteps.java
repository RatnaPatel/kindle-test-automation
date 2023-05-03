package ca.amazon.ta.common.steps;

import static ca.amazon.ta.common.util.Constant.DEFAULT_WEB_DRIVER_WAIT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Base Step class to inject web driver in abstract layer
 */
public class BaseSteps {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected int defaultWebDriverWait;

	public BaseSteps(WebDriver driver) {
		this(driver, DEFAULT_WEB_DRIVER_WAIT);
	}

	public BaseSteps(WebDriver driver, int defaultWebDriverWait) {
		this.driver = driver;
		this.defaultWebDriverWait = defaultWebDriverWait;
		wait = new WebDriverWait(driver, defaultWebDriverWait);
	}

}