package org.infinite.commonfunctions;

import com.aventstack.extentreports.ExtentReports;
import org.infinite.commands.ActionDriver;
import org.infinite.config.StartBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonFunctions {
    public WebDriver driver;
    public ActionDriver actionDriver;

    public CommonFunctions(){

        driver= StartBrowser.driver;
        actionDriver=new ActionDriver();

    }
    public void AssertText(By locator, String elementName,String expectedText) throws Exception {
        StartBrowser.childtest=StartBrowser.parenttest.createNode("AssertText" +expectedText);
        try{
           String actualText=driver.findElement(locator).getText();
            Assert.assertEquals(actualText, expectedText);
            StartBrowser.childtest.pass("Assertion Passed");
        }
        catch (AssertionError e){
            StartBrowser.childtest.fail("Assertion Failed");
            throw new Exception();
        }

    }
}
