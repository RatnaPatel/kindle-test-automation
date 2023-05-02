package ca.amazon.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ca.amazon.ta.common.pages.BasePage;

/**
 * Product page, common for all types of products
 */
public class ProductPage extends BasePage {

	private static final String BUY_NOW_BUTTON_ID = "buy-now-button";

	private static ProductPage pageObj;
	
//	@FindBy(how = How.ID, using = BUY_NOW_BUTTON_ID)
//    private WebElement buyNowButton;
	
	public ProductPage(WebDriver webDriver) {
		super(webDriver, BUY_NOW_BUTTON_ID);
	}

	public static ProductPage using(WebDriver driver) {
		if (pageObj == null) {
			pageObj = new ProductPage(driver);
		}
		return pageObj;
	}

	public ProductPage goToProductPage() {
		return this;
	}
	
	public boolean isBuyNowPresent() {
		return isElementPresent(By.id(BUY_NOW_BUTTON_ID));
	}
	
	public SignInPage buyNow() {
		click(getElement(By.id(BUY_NOW_BUTTON_ID)));
		return new SignInPage(driver);
	}

}
