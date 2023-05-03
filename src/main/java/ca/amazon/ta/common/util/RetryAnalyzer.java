package ca.amazon.ta.common.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	/*
	 * This method decides how many times a test needs to be rerun. TestNg will call
	 * this method every time a test fails. So we can apply logic here to decide
	 * when to rerun the test.
	 * 
	 * For now, this method will return true if a tests needs to be retried and
	 * false it not.
	 */

	@Override
	public boolean retry(ITestResult result) {

		if (counter < Constant.TEST_RETRY_LIMIT) {
			counter++;
			return true;
		}
		return false;
	}
}