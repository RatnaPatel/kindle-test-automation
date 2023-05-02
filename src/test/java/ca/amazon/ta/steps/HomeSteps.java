package ca.amazon.ta.steps;

import org.openqa.selenium.WebDriver;

import ca.amazon.ta.common.steps.BaseSteps;
import ca.amazon.ta.pages.HomePage;
import io.qameta.allure.Step;

/**
 *  steps on hope page
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
	
	@Step
	public void goToHomePage() {
		HomePage.using(driver).goToHomePage();
	}
	
	@Step
	public void clickHambergerMenu() {
		HomePage.using(driver).clickHamburgerMenu();
	}
	@Step
	public boolean isHambergerMenuPoppedUp() {
		return HomePage.using(driver).isHambuergerMenuPoppedUp();
	}
	
	@Step
	public void selectKindleProduct() {
		HomePage.using(driver).selectKindleMenu();
		HomePage.using(driver).selectKindleProduct();
	}
	
}