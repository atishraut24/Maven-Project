package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.OrangeHRM.qa.base.TestBase;

public class Listners extends TestBase implements ITestListener {

	public Listners() throws IOException {
		super();
	}
	ExtentTest test;
	
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Test Passed");
	}
	
	public void onTestFailure(ITestResult result ) {
		//Screenshot
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testmethodname=result.getMethod().getMethodName();
		try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotAs(testmethodname),result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
       public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	

}




