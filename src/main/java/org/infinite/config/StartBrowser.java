package org.infinite.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.time.Duration;

public class StartBrowser {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest parenttest;
    public static ExtentTest childtest;
    ExtentSparkReporter sparkreporter;
    @BeforeTest
    public void generateReport(){
        sparkreporter=new ExtentSparkReporter("Reports/MyAutomationReport.html");
        extent=new ExtentReports();
        extent.attachReporter(sparkreporter);
    }

    @BeforeClass

    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @BeforeMethod

    public void methodName(Method method){
        parenttest= extent.createTest(method.getName());

    }


    @AfterClass

    public void tearDown(){
        extent.flush();
        driver.quit();
    }

}
