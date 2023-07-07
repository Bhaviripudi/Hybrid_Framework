package learning.framework.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//listener class used for generate extent reports
public class ExtentReporting extends TestListenerAdapter {

	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest et;
	public static ExtentHtmlReporter reporter;

	public void onTestStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-report-" + timeStamp + ".html";
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output/" + reportName);
		reporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");

		extent.attachReporter(reporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("User", "Sulochana");
		extent.setSystemInfo("Env", "Test");

		reporter.config().setDocumentTitle("Testing Framework");
		reporter.config().setReportName("Functional Test Report");
		reporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult result) {
		et = extent.createTest(result.getName());// create new entry in the report
		et.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));// send passed information

	}

	public void onTestFailure(ITestResult result) {
		et = extent.createTest(result.getName());
		et.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String screenshotpath = System.getProperty("user.dir" + "\\Screenshots" + result.getName() + ".png");
		File file = new File(screenshotpath);

		if (file.exists()) {
			try {
				et.fail("Screenshot is below " + et.addScreenCaptureFromPath(screenshotpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		et = extent.createTest(result.getName());
		et.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
