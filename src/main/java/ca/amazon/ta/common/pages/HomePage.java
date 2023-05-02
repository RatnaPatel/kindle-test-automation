package ca.amazon.ta.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Home page of the site
 */
public class HomePage extends Page {

	private static final String NAV_HAMBURGER_MENU_ID = "nav-hamburger-menu";
	
	private static final String HMENU_CONTAINER_ID = "hmenu-container";
	
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
		getHamburgerMenu().click();
	}
	public WebElement getHamburgerMenu() {
		return driver.findElement(By.id(NAV_HAMBURGER_MENU_ID));
	}
}