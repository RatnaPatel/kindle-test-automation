package ca.amazon.ta.steps;

import org.openqa.selenium.WebDriver;

import ca.amazon.ta.common.steps.BaseSteps;
import ca.amazon.ta.pages.HomePage;
import io.qameta.allure.Step;

/**
 * steps on hope page. Steps added for Allure reports
 */
public class HomeSteps extends BaseSteps {

	private static HomeSteps stepObj;

	protected HomeSteps(WebDriver driver) {
		super(driver);
	}

	public static HomeSteps using(WebDriver driver) {
		if (stepObj == null) {
			stepObj = new HomeSteps(driver);
		}
		return stepObj;
	}

	@Step("1. Launch amazon.ca")
	public void goToHomePage() {
		HomePage.using(driver).goToHomePage();
	}

	@Step("2. Click on left hamberger menu.")
	public void clickHambergerMenu() {
		HomePage.using(driver).clickHamburgerMenu();
	}

	@Step("3. Verify hamberger menu opened successfully.")
	public boolean isHambergerMenuPoppedUp() {
		return HomePage.using(driver).isHambuergerMenuPoppedUp();
	}

	@Step("4. Select Kindle option.")
	public void selectKindleProduct() {
		HomePage.using(driver).selectKindleMenu();
		HomePage.using(driver).selectKindleProduct();
	}

}