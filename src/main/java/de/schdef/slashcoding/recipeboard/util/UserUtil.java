package de.schdef.slashcoding.recipeboard.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserUtil {

	private static Properties properties;

	private static void init() {
		InputStream resourceAsStream = UserUtil.class
				.getResourceAsStream("login.properties");
		try {
			Properties loadingProperties = new Properties();
			loadingProperties.load(resourceAsStream);
			properties = loadingProperties;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		if (properties == null) {
			init();
		}
		return properties;
	}

}
