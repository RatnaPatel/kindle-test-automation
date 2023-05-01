package ca.amazon.ta.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Sign in page
 */
public class SignInPage extends Page {

	private static final String EMAIL_ID = "ap_email";

	public SignInPage(WebDriver webDriver) {
		super(webDriver, null);
	}

	public WebElement getEmailOrPhoneInput() {
		return driver.findElement(By.id(EMAIL_ID));
	}

}
