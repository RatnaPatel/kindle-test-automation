package ca.amazon.ta.common.config;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Loads configuration from resource files.
 */
public class Configuration {

  private static final String DEBUG_PROPERTIES = "/debug.properties";

  private Properties properties;

  public Configuration() throws IOException {
  	this(System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  public Configuration(String fromResource) throws IOException {
    properties = new Properties();
    properties.load(Configuration.class.getResourceAsStream(fromResource));
  }

  public Capabilities getCapabilities() throws IOException {
    String capabilitiesFile = properties.getProperty("capabilities");

    Properties capsProps = new Properties();
    capsProps.load(Configuration.class.getResourceAsStream(capabilitiesFile));

    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capsProps.stringPropertyNames()) {
      String value = capsProps.getProperty(name);
      if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else if (value.startsWith("file:")) {
        capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
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
