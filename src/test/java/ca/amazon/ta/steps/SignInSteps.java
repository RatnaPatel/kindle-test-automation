package ca.amazon.ta.steps;

import org.openqa.selenium.WebDriver;

import ca.amazon.ta.common.steps.BaseSteps;
import ca.amazon.ta.pages.SignInPage;
import io.qameta.allure.Step;

/**
 * steps on Sign in page
 */
public class SignInSteps extends BaseSteps {

	private static SignInSteps stepObj;

	protected SignInSteps(WebDriver driver) {
		super(driver);
	}

	public static SignInSteps using(WebDriver driver) {
		if (stepObj == null) {
			stepObj = new SignInSteps(driver);
		}
		return stepObj;
	}

	@Step("8. Launch Sign In page.")
	public void goToSignInPage() {
		SignInPage.using(driver).goToSignInPage();
	}

	@Step("9. Verify for email/phone text box present.")
	public boolean isEmailOrPhoneInputPresent() {
		return SignInPage.using(driver).isEmailOrPhoneInputPresent();
	}

}