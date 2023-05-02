package ca.amazon.ta.steps;

import org.openqa.selenium.WebDriver;

import ca.amazon.ta.common.steps.BaseSteps;
import ca.amazon.ta.pages.ProductPage;
import io.qameta.allure.Step;

/**
 *  steps on hope page
 */
public class ProductSteps extends BaseSteps {

private static ProductSteps stepObj;
	
	protected ProductSteps(WebDriver driver) {
		super(driver);
	}
	
	public static ProductSteps using(WebDriver driver) {
		if (stepObj == null) {
			stepObj = new ProductSteps(driver);
		}
		return stepObj;
	}
	
	@Step
	public void goToProductPage() {
		ProductPage.using(driver).goToProductPage();
	}
	
	@Step
	public void clickOnBuyNow() {
		ProductPage.using(driver).buyNow();
	}
	@Step
	public boolean isBuyNowPresent() {
		return ProductPage.using(driver).isBuyNowPresent();
	}
	
}