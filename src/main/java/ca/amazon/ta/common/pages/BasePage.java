package ca.amazon.ta.common.pages;

import static ca.amazon.ta.common.util.Constant.DEFAULT_WEB_DRIVER_WAIT;
import static ca.amazon.ta.common.util.Constant.GLOBAL_TIMEOUT;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 * followed.
 */
public abstract class BasePage {

	protected WebDriver driver;

	protected WebDriverWait wait;

	/*
	 * Constructor injecting the WebDriver interface. Added wait in case page does
	 * not load
	 * 
	 * @param webDriver, String
	 */
	public BasePage(WebDriver driver, String pageLoadConfimationId) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(DEFAULT_WEB_DRIVER_WAIT, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(this.driver, GLOBAL_TIMEOUT);
		if (pageLoadConfimationId != null) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pageLoadConfimationId)));
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public WebElement getElement(By by) {
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void click(final WebElement element) {
		wait.until(new ExpectedCondition<Object>() {
			@Nullable
			@Override
			public Object apply(@Nullable WebDriver driver) {
				/*
				 * Wait until the element's .isDisplayed is true (which is essentially what
				 * visibilityOfElementLocated is checking for). Wait until the element's
				 * isEnabled is true (which is essentially what elementToBeClickable is checking
				 * for)
				 */
				return element.isDisplayed() && element.isEnabled();
			}
		});
		element.click();
	}

}
