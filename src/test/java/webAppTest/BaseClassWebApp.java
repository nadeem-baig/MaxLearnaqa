package webAppTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utility.BrowserFactory;
import utility.ExcelDataprovider;
import utility.ReadConfig;

public class BaseClassWebApp {

	public static WebDriver driver;
	public static ExcelDataprovider excel;
	public static ReadConfig config;
	// public static Logger log;
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	@Parameters({ "reportname" })
	@BeforeSuite(alwaysRun = true)
	public void setUpSuite(String reportname) throws FileNotFoundException {
		excel = new ExcelDataprovider();
		config = new ReadConfig();
		String timestamp = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());
		        
		String Reportname = reportname+ timestamp;
		 
		
		htmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/ExtentReports/" + Reportname + ".html"));
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.loadXMLConfig("extent-config.xml");
		//extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		//htmlReporter.loconfig().setDocumentTitle("AutomationTesting Report");

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.UserWebApp());
		return;
	}

	@BeforeMethod(alwaysRun = true)
	public void beforMethod() {

		extent.flush();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		// logger = extent.createTest(result.getMethod().getDescription());

		if (result.getStatus() == ITestResult.SUCCESS) {
			// logs will be captured in report
			// logger.log(Status.PASS, MarkupHelper.createLabel(result.getName,
			// ExtentColor.GREEN));
			logger.log(Status.PASS, "Test Success");
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			// logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test
			// Case PASSED", ExtentColor.GREEN));
			logger.log(Status.FAIL, "Test Failed");
			logger.log(Status.FAIL, result.getThrowable());
			String screenshotpath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
			File file = new File(screenshotpath);
			if (file.exists()) {
				try {
					logger.fail("screenshoy below is " + logger.addScreenCaptureFromPath(screenshotpath));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			// logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
			// ExtentColor.ORANGE));
			logger.log(Status.SKIP, "Test Scipped");
			logger.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
		return;
	}

	/*
	 * @AfterSuite public void quitBrowser(WebDriver driver) { driver.quit(); }
	 */
}
