package ca.amazon.ta.kindle;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ca.amazon.ta.common.pages.ProductPage;
import ca.amazon.ta.common.pages.SignInPage;
import ca.amazon.ta.common.test.TestNgTestBase;
import ca.amazon.ta.kindle.pages.HomePageKindleExtension;

public class KindleBuyNowFlowTest extends TestNgTestBase {

  private HomePageKindleExtension homePage;

  @BeforeMethod
  public void initPageObjects() {
    homePage = PageFactory.initElements(driver, HomePageKindleExtension.class);
  }

  @Test
  public void testKindleBuyNowFlow() {
	  driver.get(baseUrl);
	  ProductPage kindleProductPage = homePage.selectKindle();
	  SignInPage signInPage = kindleProductPage.buyNow();  
	  Assert.assertNotNull(signInPage.getEmailOrPhoneInput());
  }
}
