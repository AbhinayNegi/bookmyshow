package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BInitializeBrowser {
	protected static WebDriver driver;
	protected Properties config;
	protected String configFileName = "config.properties";

	@BeforeTest
	protected void initBrowser() throws IOException {
		InputStream in = new FileInputStream(configFileName);
		config = new Properties();
		config.load(in);

		BrowserManager.setDriver(config.getProperty("browser"));

		driver = BrowserManager.getDriver();
		
		ExtentReportManager.initReport();
	}
}
