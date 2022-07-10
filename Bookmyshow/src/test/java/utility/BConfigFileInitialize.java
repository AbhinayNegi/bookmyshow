package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class BConfigFileInitialize {
	protected Properties config;
	protected String configFileName = "config.properties";
	
	protected void initBrowser() throws IOException {
		InputStream in = new FileInputStream(configFileName);
		config = new Properties();
		config.load(in);
	}
}
