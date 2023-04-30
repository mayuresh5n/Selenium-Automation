package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {



    public static ExtentReports getReportObject() {
        ExtentReports extent;
        String path = System.getProperty("user.dir")+"\\src\\index.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("");
        reporter.config().setDocumentTitle("");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.getStats();
        extent.setSystemInfo("Tester", "Mayuresh N");
        extent.setSystemInfo("Company", "Data Corp Inc");
        extent.createTest(path);
        return extent;
    }

}
