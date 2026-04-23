package org.infinite.commands;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.infinite.config.StartBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ActionDriver {
    public WebDriver driver;
    public ActionDriver(){
        driver= StartBrowser.driver;
    }

    /**
     * This command is used to navigate to any URL
     * @param url
     */
    public void navigatetoapplication(String url){
        try {
            driver.get(url);
            StartBrowser.childtest.pass("Navigated Successfully" +url);
        } catch (Exception e){
            StartBrowser.childtest.fail("Failed to Launch Browser");
        }


    }

    /**
     * Used tp perform Action on Elements
     * @param locator
     * @param elementname
     * @throws Exception
     */
    public void click(By locator, String elementname) throws Exception {

        try{
            driver.findElement(locator).click();
            StartBrowser.childtest.pass("Successfully performed click action on :" +elementname);
        } catch (Exception e){
            StartBrowser.childtest.fail("Failed to perform click action" +elementname,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
            StartBrowser.childtest.info(e);
            throw new Exception();

        }

    }

    public String screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

    }
    public void type(By locator, String testdata, String elementname) throws Exception {
        try{
            driver.findElement(locator).sendKeys(testdata);
            StartBrowser.childtest.pass("Successfully performed type action on :" +elementname +" with data" +testdata);
        } catch (Exception e){
            StartBrowser.childtest.fail("Failed to perform type action" +elementname,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
            StartBrowser.childtest.info(e);
            throw new Exception();

        }

    }
}
