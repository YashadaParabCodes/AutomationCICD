package YashadaParabAutomation.GlobalData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports reports() {
		
		String path= System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("YashadaParabAutomation Results");
		reporter.config().setReportName("Test Results");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Yashada Parab");
		return extent;
		
	}

}
