package ca.amazon.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ca.amazon.ta.common.pages.BasePage;

/**
 * Home page of the site
 */
public class HomePage extends BasePage {

	private static final String NAV_HAMBURGER_MENU_ID = "nav-hamburger-menu";
	
	private static final String HMENU_CONTAINER_ID = "hmenu-container";
	
	private static final String HMENU_CONTENT_ID = "hmenu-content";

	private static final String KINDLE_MENU_ITEM_XPATH = "//a[text() = 'Kindle']";

	private static final String KINDLE_SUB_MENU_ITEM_XPAHT = "//a/div[text() = 'Kindle']";
	
	private static final String HMENU_VISIBLE_CLASS = "hmenu-visible";
	
	private static HomePage pageObj;
	
//    @FindBy(how = How.ID, using = HMENU_CONTAINER_ID)
//    private WebElement hMenuContainer;
    
    
	public HomePage(WebDriver webDriver) {
		super(webDriver, null);
	}
	
	public static HomePage using(WebDriver driver) {
		if (pageObj == null) {
			pageObj = new HomePage(driver);
			pageObj.goToHomePage();
		}
		return pageObj;
	}

	public HomePage goToHomePage() {
		driver.get(baseUrl);
		return this;
	}
	
	public WebElement getHMenuContainer() {
		if(driver.findElement(By.id(HMENU_CONTAINER_ID)).isDisplayed()) {
			return driver.findElement(By.id(HMENU_CONTAINER_ID));
		} else {
			throw new IllegalStateException("Some issue!!");
		}
	}
	public boolean isHambuergerMenuPoppedUp(){
		return isElementPresent(By.id(HMENU_CONTAINER_ID));
	}
	public void clickHamburgerMenu() {
		if(isElementPresent(By.id(NAV_HAMBURGER_MENU_ID))) {
			click(getElement(By.id(NAV_HAMBURGER_MENU_ID)));
		}
	}
	
	public void selectKindleMenu() {
		selectHSpecificMenu(KINDLE_SUB_MENU_ITEM_XPAHT);
	}
	
	public void selectHSpecificMenu(String xPathForHMenu) {
		WebElement hMenuContainer = getHMenuContainer();
		
		WebElement kindelSubMenu = hMenuContainer.findElement(By.xpath(xPathForHMenu));
		
		click(kindelSubMenu);
	}
	
	public ProductPage selectKindleProduct() {
		
		return selectSpecificProduct(KINDLE_MENU_ITEM_XPATH);
	}
	
	public ProductPage selectSpecificProduct(String productXPath) {
		
		WebElement productMenu = getHMenuContainer().findElement(By.id(HMENU_CONTENT_ID)).findElement(By.className(HMENU_VISIBLE_CLASS)).findElement(By.xpath(productXPath));
		
		click(productMenu);
		
		return new ProductPage(driver);
	}
}