package ca.amazon.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.amazon.ta.common.pages.BasePage;

/**
 * Sign in page
 */
public class SignInPage extends BasePage {

	private static final String EMAIL_ID = "ap_email";

	private static SignInPage pageObj;
	
	public SignInPage(WebDriver webDriver) {
		super(webDriver, EMAIL_ID);
	}

	public static SignInPage using(WebDriver driver) {
		if (pageObj == null) {
			pageObj = new SignInPage(driver);
		}
		return pageObj;
	}

	public SignInPage goToSignInPage() {
		return this;
	}
	
	public boolean isEmailOrPhoneInputPresent() {
		return isElementPresent(By.id(EMAIL_ID));
	}
	
	public WebElement getEmailOrPhoneInput() {
		return getElement(By.id(EMAIL_ID));
	}

}
