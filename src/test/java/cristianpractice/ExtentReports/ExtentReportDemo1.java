package cristianpractice.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo1 {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSparkReporter
		//path to create our local html file
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		//this variable control the report settings
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//Configuring our report settings
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Cristian");
	}

	@Test
	public void initialDemo() {
		//Declaring variable test so as to control the specific test
	    ExtentTest test =	extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		//we can report test fail manually
		test.fail("Result do not match");
		//Sending test results
		extent.flush();
	}

}
