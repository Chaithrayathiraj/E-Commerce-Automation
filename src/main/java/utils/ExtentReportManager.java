package utils;









import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "Nixonex E-Commerce");
            extent.setSystemInfo("Tester", "Chaithra");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
