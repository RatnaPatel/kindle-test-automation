package ca.amazon.ta.common.util;

import ca.amazon.ta.common.config.Configuration;

/*
 * This is a utility class to declare and define static variable
 */
public final class Constant {
	public static final int DEFAULT_WEB_DRIVER_WAIT = 3;
	public static final int GLOBAL_TIMEOUT = 5;
	public static final int TEST_RETRY_LIMIT = 3;
	
	public static final String SCREENSHOT_DIR = "Screenshots/"; // "D://screenshots/"; 
	public static final String SCREENSHOT_FILE_EXT = ".png";
	
	public static final String APPLICATION_PROPERTIES_FILE = "application.properties";

	public static final String CAPABILITIES = "capabilities";
	public static final String SITE_URL = Configuration.getInstance().getProperty("site.url");
	public static final String GRID_URL = "grid.url";

}
