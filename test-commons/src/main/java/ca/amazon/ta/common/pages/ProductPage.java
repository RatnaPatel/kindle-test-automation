package ca.amazon.ta.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Product page, common for all types of products
 */
public class ProductPage extends Page {

	private static final String BUY_NOW_BUTTON_ID = "buy-now-button";

	public ProductPage(WebDriver webDriver) {
		super(webDriver, BUY_NOW_BUTTON_ID);
	}

	public SignInPage buyNow() {
		WebElement buyNowButton = driver.findElement(By.id(BUY_NOW_BUTTON_ID));
		buyNowButton.click();
		return new SignInPage(driver);
	}

}
