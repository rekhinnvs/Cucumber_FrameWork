package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {
    static ExtentReports extentReports;
    WebDriver driver;

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        return driver;
    }

    public WebDriver initializeCustomDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void implicitWaitFor(int timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public static Logger getLogger(String className) {
        return LogManager.getLogger(className);
    }

    public ExtentReports htmlReporter() {
        String path = "output/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Test results");
        reporter.config().setReportName("Rekhin");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }

    public File takeScreenShots(WebDriver driver, String testName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File outPutDirectory = new File("./output");
        //Delete all the files in the directory before copying the new files.
        //FileUtils.cleanDirectory(outPutDirectory);
        File screenShotFile = new File(outPutDirectory.toString() + "/" + testName + ".png");
        FileUtils.copyFile(file, screenShotFile);
        System.out.println("absolute path of the screenshot " + screenShotFile.getAbsolutePath());
        return screenShotFile;
    }

}
