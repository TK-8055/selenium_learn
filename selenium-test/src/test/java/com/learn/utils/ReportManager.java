package com.learn.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/AutomationReport.html");
            spark.config().setReportName("Selenium Automation Report");
            spark.config().setDocumentTitle("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "TK");
            extent.setSystemInfo("Browser", "Firefox");
        }
        return extent;
    }
}
