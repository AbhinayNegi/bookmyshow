package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	static String path = System.getProperty("user.dir") + "\\reports\\index.html";
	
	public static ExtentReports extentReports;
	
	public static void initReport() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Saakra World Hospital");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
	}
}
