package myframework1.framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import myframework1.framework.base;
import resources.extentreport;

public class listener extends base implements ITestListener {
	extentreport ex =new extentreport();
	ExtentReports extent = ex.config();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		extent.flush();
		

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String name = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(name, driver), name);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String name = result.getMethod().getMethodName();
		test =extent.createTest(name);
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "test passed");

	}
	

}
