package baoveCSDL.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class In {
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void afterClass() {
        extent.flush();
    }

    @Test
    public void testAdminLogin() {
        test = extent.createTest("testAdminLogin");
        // Your test logic here
        test.log(Status.INFO, "Test started");
        // Add more logs as needed
        test.log(Status.PASS, "Test passed");
    }

    // Add similar methods for other test cases
}