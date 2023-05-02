package ca.amazon.ta.common.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

	private static final int GLOBAL_TIMEOUT = 20;

	protected WebDriver driver;

	protected WebDriverWait wait;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(WebDriver driver, String pageLoadConfimationId) {
		this.driver = driver;
//		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		this.wait = new WebDriverWait(this.driver, GLOBAL_TIMEOUT);
		if(pageLoadConfimationId != null) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pageLoadConfimationId)));	
		}
		
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
