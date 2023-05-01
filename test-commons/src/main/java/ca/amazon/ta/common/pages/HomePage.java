package ca.amazon.ta.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ca.amazon.ta.common.pages.Page;

/**
 * Home page of the site
 */
public class HomePage extends Page {

	private static final String NAV_MENU_ID = "nav-main";
	private static final String NAV_HAMBURGER_MENU_ID = "nav-hamburger-menu";
	

	private static final String HMENU_CONTAINER_ID = "hmenu-container";

	private static final String HMENU_VISIBLE_CLASS = "hmenu-visible";

	private static final String HMENU_CONTENT_ID = "hmenu-content";

	private static final String KINDLE_MENU_ITEM_XPATH = "//a[text() = 'Kindle']";

	private static final String KINDLE_SUB_MENU_ITEM_XPAHT = "//a/div[text() = 'Kindle']";
	
	@FindBy(how = How.ID, using = NAV_HAMBURGER_MENU_ID)
	@CacheLookup
	private WebElement hamburgerMenu;
	 
	
	public HomePage(WebDriver webDriver) {
		super(webDriver, null);
	}

	public WebElement getHMenuContainer() {
		clickHamburgerMenu();
		if(driver.findElement(By.id(HMENU_CONTAINER_ID)).isDisplayed()) {
			return driver.findElement(By.id(HMENU_CONTAINER_ID));
		} else {
			throw new IllegalStateException("Some issue!!");
		}
	}
	
	public void clickHamburgerMenu() {
		hamburgerMenu.click();
	}
	public WebElement getHamburgerMenu() {
		return hamburgerMenu;
	}

}
