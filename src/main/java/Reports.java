import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Reports {

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeTest
    public void initialiseReport() throws UnknownHostException {
        String baseDirectory = System.getProperty("user.dir");
        extentSparkReporter = new ExtentSparkReporter(baseDirectory + "/report/extentreport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Hostname", InetAddress.getLocalHost().getHostName());
        extentReports.setSystemInfo("OS", "windows");
        extentReports.setSystemInfo("Tester", "Manna Zachariah");
        extentReports.setSystemInfo("Browser", "Chrome");

    }


    public static void createTest(String testcaseName) {
        extentTest = extentReports.createTest(testcaseName);
    }

    @AfterTest
    public void closeReport() {
        extentReports.flush();
    }
}

