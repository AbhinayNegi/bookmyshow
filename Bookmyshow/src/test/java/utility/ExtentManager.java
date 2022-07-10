package utility;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports reports;

	public static void initReports() {
		reports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "//Test reports//report.html"));
		reports.attachReporter(sparkReporter);
	}

	public static ExtentTest createNewTest(String nameOfTest) {
		return reports.createTest(nameOfTest);
	}

	public static void flushReport() {

		reports.flush();
	}
}
