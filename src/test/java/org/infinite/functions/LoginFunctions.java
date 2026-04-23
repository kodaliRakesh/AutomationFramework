package org.infinite.functions;

import org.infinite.commands.ActionDriver;
import org.infinite.commonfunctions.CommonFunctions;
import org.infinite.config.StartBrowser;
import org.infinite.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginFunctions {
    public WebDriver driver;
    public ActionDriver actionDriver;
    public CommonFunctions commonFunctions;
    public LoginFunctions(){
        driver= StartBrowser.driver;
        actionDriver=new ActionDriver();
        commonFunctions=new CommonFunctions();
    }
    public void login() throws Exception {
        StartBrowser.childtest=StartBrowser.parenttest.createNode("Login to Application");
        actionDriver.navigatetoapplication("https://www.saucedemo.com/");
        actionDriver.type(LoginPage.txtusername, "standard_user", "UserName TextBox");
        actionDriver.type(LoginPage.txtpassword, "secret_sauce", "Password TextBox");
        actionDriver.click(LoginPage.btnlogin, "Login Button");

    }
    public void assertDashboard(String expectedText) throws Exception {
        //StartBrowser.childtest=StartBrowser.parenttest.createNode("Verify Dashboard Header");
        commonFunctions.AssertText(LoginPage.logoSauceDemo, "Header",expectedText);
    }
}
