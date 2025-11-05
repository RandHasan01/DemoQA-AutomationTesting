package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public static void loadProperties() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(file);
		} catch (IOException e) {
			System.out.println("Error loading config.properties file: " + e.getMessage());
		}
	}

	public static String getProperty(String key) {
		if (prop == null) {
			loadProperties();
		}
		return prop.getProperty(key);
	}
}
