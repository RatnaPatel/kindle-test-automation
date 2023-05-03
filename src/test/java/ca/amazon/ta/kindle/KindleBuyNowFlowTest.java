package ca.amazon.ta.kindle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ca.amazon.ta.common.test.BaseTest;
import ca.amazon.ta.common.util.RetryAnalyzer;
import ca.amazon.ta.common.util.TestListener;
import ca.amazon.ta.steps.HomeSteps;
import ca.amazon.ta.steps.ProductSteps;
import ca.amazon.ta.steps.SignInSteps;

/**
 * This is a test class. 
 */
@Listeners(TestListener.class)
public class KindleBuyNowFlowTest extends BaseTest {

	private HomeSteps homeSteps;
	private ProductSteps productSteps;
	private SignInSteps signInSteps;

	/*
	 * This method will run before start of test to setup driver
	 */
	@BeforeClass(alwaysRun = true)
	public void setupClass() {
		this.homeSteps = HomeSteps.using(driver);
		this.productSteps = ProductSteps.using(driver);
		this.signInSteps = SignInSteps.using(driver);
	}

	/*
	 * This method will run before every test
	 */
	@BeforeMethod(alwaysRun = true)
	public void testSetup() {
		homeSteps.goToHomePage();
	}

	/*
	 * This method has all test step for amazon's buy kindle product.
	 */
	@Test(description = "Buy Kindle Flow", retryAnalyzer = RetryAnalyzer.class)
	public void testKindleBuyNowFlow() {
		homeSteps.clickHambergerMenu();
		Assert.assertTrue(homeSteps.isHambergerMenuPoppedUp(), "Menu not loaded!");
		homeSteps.selectKindleProduct();
		// productSteps.goToProductPage();// dummy.. no use
		Assert.assertTrue(productSteps.isBuyNowPresent(), "Product Page not loaded!");
		productSteps.clickOnBuyNow();
		//signInSteps.goToSignInPage();// dummy.. no use
		Assert.assertTrue(signInSteps.isEmailOrPhoneInputPresent(), "Email field not present on the page!");
	}
}
