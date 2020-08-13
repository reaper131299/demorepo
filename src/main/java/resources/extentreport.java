package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreport {
	ExtentReports extent;
	public ExtentReports config() {
		String path =System.getProperty("user.dir")+"\\reports3\\report.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("My First Report");
		report.config().setDocumentTitle("My framework Report");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "REAPER");
		return extent;
		
		


		
		}
	}


