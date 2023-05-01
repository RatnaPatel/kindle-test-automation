package ca.amazon.ta.kindle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ca.amazon.ta.common.pages.HomePage;
import ca.amazon.ta.common.pages.ProductPage;

/**
 * Kindel specific page customization
 */
public class HomePageKindleExtension extends HomePage {



	private static final String NAV_HAMBURGER_MENU_ID = "nav-hamburger-menu";
	
	private static final String HMENU_VISIBLE_CLASS = "hmenu-visible";

	private static final String HMENU_CONTENT_ID = "hmenu-content";

	private static final String KINDLE_MENU_ITEM_XPATH = "//a[text() = 'Kindle']";

	private static final String KINDLE_SUB_MENU_ITEM_XPAHT = "//a/div[text() = 'Kindle']";
	
	@FindBy(how = How.ID, using = NAV_HAMBURGER_MENU_ID)
	@CacheLookup
	private WebElement hamburgerMenu;

	public HomePageKindleExtension(WebDriver webDriver) {
		super(webDriver);
	}
	
	public ProductPage selectKindle() {
		WebElement hMenuContainer = getHMenuContainer();
		
		WebElement kindelSubMenu = hMenuContainer.findElement(By.xpath(KINDLE_SUB_MENU_ITEM_XPAHT));
		
		kindelSubMenu.click();
		WebElement kindelMenu = hMenuContainer.findElement(By.id(HMENU_CONTENT_ID)).findElement(By.className(HMENU_VISIBLE_CLASS)).findElement(By.xpath(KINDLE_MENU_ITEM_XPATH));
		
		kindelMenu.click();
		
		return new ProductPage(driver);
	 
	}

}
