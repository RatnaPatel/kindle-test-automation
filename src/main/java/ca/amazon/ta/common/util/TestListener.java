package ca.amazon.ta.common.util;

import static ca.amazon.ta.common.util.Constant.SCREENSHOT_DIR;
import static ca.amazon.ta.common.util.Constant.SCREENSHOT_FILE_EXT;

import java.io.File;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ca.amazon.ta.common.test.BaseTest;
import io.qameta.allure.Attachment;

/**
 * ITestListener listens to specific events (depending on its methods) and executes the code written 
 * inside the method.
 * In this class Logger implementation is also done as sample representation.
 *   
 */
public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class.getName());

	private WebDriver driver;

	/*
	 * onTestSuccess method is called on the success of any Test and take
	 * screenshot.
	 */
	public void onTestSuccess(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	/*
	 * onTestFailure method is called on the failure of any Test and take
	 * screenshot.
	 */
	public void onTestFailure(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	/*
	 * onTestSkipped method is called on skipped of any Test and take screenshot.
	 */
	public void onTestSkipped(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	/*
	 * onTestSkipped method is called on failure of configuration loading and take
	 * screenshot.
	 */
	public void onConfigurationFailure(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	/*
	 * onTestSkipped method is called on skipped of configuration loading and take
	 * screenshot.
	 */
	public void onConfigurationSkip(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	private String takeAScreenshot(ITestResult result) {
		Object currentClass = result.getInstance();
		driver = ((BaseTest) currentClass).getDriver();
		String screenshotLink = takeAScreenshot(driver, result.getName(), "AmazonTest");
		result.setAttribute("screenshot", screenshotLink);
		takeAScreenshot();
		return screenshotLink;
	}

	/**
	 * Result/Failure screenshots for the allure framework test results.
	 */
	@Attachment(value = "Web Page screenshot", type = "image/png")
	private byte[] takeAScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	/*
	 * creating file and copying screen shot to it.
	 */
	public static String takeAScreenshot(WebDriver driver, String resultName, String screenshotName) {
		logger.info("taking screenshot");
		String screenshotLink = "";
		Date d = new Date();
		String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File(SCREENSHOT_DIR + resultName + "_" + timeStamp + SCREENSHOT_FILE_EXT);
			FileUtils.copyFile(source, destination);
			screenshotLink = destination.getCanonicalPath();
			logger.info("screenshot taken");
		} catch (Exception e) {
			logger.debug("Exception while taking screenshot " + e.getMessage());
		}
		return screenshotLink;
	}

}