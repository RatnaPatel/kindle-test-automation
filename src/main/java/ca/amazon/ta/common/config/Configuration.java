package ca.amazon.ta.common.config;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import ca.amazon.ta.common.util.Constant;

/**
 * Loads configuration from resource files.
 */
public class Configuration {

	private static Configuration configuration = new Configuration();
	private Properties properties;

	private Configuration() {
		this(System.getProperty(Constant.APPLICATION_PROPERTIES_FILE));
	}

	private Configuration(String fromResource) {
		properties = new Properties();
		try {
			properties.load(Configuration.class.getResourceAsStream(fromResource));
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't load properties file.");
		}
	}

	public static Configuration getInstance() {
		return configuration;
	}

	/*
	 * Loads capabilities for active/selected profile from the resource file
	 */
	public Capabilities getCapabilities() throws IOException {
		String capabilitiesFile = properties.getProperty(Constant.CAPABILITIES);

		Properties capsProps = new Properties();
		capsProps.load(Configuration.class.getResourceAsStream(capabilitiesFile));

		DesiredCapabilities capabilities = new DesiredCapabilities();
		for (String name : capsProps.stringPropertyNames()) {
			String value = capsProps.getProperty(name);
			if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
				capabilities.setCapability(name, Boolean.valueOf(value));
			} else if (value.startsWith("file:")) {
				capabilities.setCapability(name,
						new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
			} else {
				capabilities.setCapability(name, value);
			}
		}

		return capabilities;
	}

	public boolean hasProperty(String name) {
		return properties.containsKey(name);
	}

	public String getProperty(String name) {
		return properties.getProperty(name);
	}
}
