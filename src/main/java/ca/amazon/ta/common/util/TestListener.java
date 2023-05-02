package ca.amazon.ta.common.util;

import static ca.amazon.ta.common.util.Constant.SCREENSHOT_DIR;
import static ca.amazon.ta.common.util.Constant.SCREENSHOT_FILE_EXT;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ca.amazon.ta.common.test.BaseTest;

public class TestListener extends TestListenerAdapter {
	
	private WebDriver driver;

	public void onTestSuccess(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
		
	}

	public void onTestFailure(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
		
	}

	public void onTestSkipped(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
		
	}

	public void onConfigurationFailure(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	public void onConfigurationSkip(ITestResult iTestResult) {
		takeAScreenshot(iTestResult);
	}

	private String takeAScreenshot(ITestResult result) {
		Object currentClass = result.getInstance();
		driver = ((BaseTest) currentClass).getDriver();
		String screenshotLink = takeAScreenshot(driver, result.getName(), "TestFailure");
		result.setAttribute("screenshot", screenshotLink);
		takeAScreenshot();
		return screenshotLink;
	}

	/**
	 * Result/Failure screenshots for the allure framework test results.
	 */
	//@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] takeAScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public static String takeAScreenshot(WebDriver driver, String resultName, String screenshotName) {
		String screenshotLink = "";
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File(SCREENSHOT_DIR + resultName + SCREENSHOT_FILE_EXT);
			FileUtils.copyFile(source, destination);
			screenshotLink = "Screenshots/" + resultName + SCREENSHOT_FILE_EXT;
		} catch (Exception e) {
//			Logger.info("Exception while taking screenshot " + e.getMessage());
		}
		return screenshotLink;
	}
	
}