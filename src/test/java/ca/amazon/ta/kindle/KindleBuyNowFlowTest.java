package ca.amazon.ta.kindle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ca.amazon.ta.common.test.BaseTest;
import ca.amazon.ta.steps.HomeSteps;
import ca.amazon.ta.steps.ProductSteps;
import ca.amazon.ta.steps.SignInSteps;

public class KindleBuyNowFlowTest extends BaseTest {

	private HomeSteps homeSteps;
	private ProductSteps productSteps;
	private SignInSteps signInSteps;

	@BeforeClass(alwaysRun = true)
	public void setupClass() {
		this.homeSteps = HomeSteps.using(driver);
		this.productSteps = ProductSteps.using(driver);
		this.signInSteps = SignInSteps.using(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void testSetup() {
		homeSteps.goToHomePage();
	}
	
  @Test
  public void testKindleBuyNowFlow() {
	  homeSteps.clickHambergerMenu();
	  Assert.assertTrue(homeSteps.isHambergerMenuPoppedUp(), "Something wrong!");
	  homeSteps.selectKindleProduct();
	  productSteps.goToProductPage();//dummy.. no use
	  Assert.assertTrue(productSteps.isBuyNowPresent(), "Product Page not loaded!");
	  productSteps.clickOnBuyNow();
	  signInSteps.goToSignInPage();//dummy.. no use
	  Assert.assertTrue(signInSteps.isEmailOrPhoneInputPresent(), "Email field not present on the page!");
  }
}
