package org.infinite.pages;

import org.infinite.commands.ActionDriver;
import org.infinite.commonfunctions.CommonFunctions;
import org.infinite.config.StartBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static By txtusername= By.id("user-name");
    public static By txtpassword= By.id("password");
    public static By btnlogin=By.id("login-button");
    public static By logoSauceDemo=By.className("app_logo");
    public WebDriver driver;
    public ActionDriver actionDriver;
    public CommonFunctions commonFunctions;

    public LoginPage(){
        driver=StartBrowser.driver;
        actionDriver=new ActionDriver();
        commonFunctions=new CommonFunctions();
    }
    public void login() throws Exception {
        StartBrowser.childtest=StartBrowser.parenttest.createNode("Login to Application");
        actionDriver.navigatetoapplication("https://www.saucedemo.com/");
        actionDriver.type(txtusername, "standard_user", "UserName TextBox");
        actionDriver.type(txtpassword, "secret_sauce", "Password TextBox");
        actionDriver.click(btnlogin, "Login Button");

    }
    public void login(String username, String password) throws Exception {
        StartBrowser.childtest=StartBrowser.parenttest.createNode("Login to Application");
        actionDriver.navigatetoapplication("https://www.saucedemo.com/");
        actionDriver.type(txtusername, username, "UserName TextBox");
        actionDriver.type(txtpassword, password, "Password TextBox");
        actionDriver.click(btnlogin, "Login Button");

    }
    public void assertDashboard(String expectedText) throws Exception {
        //StartBrowser.childtest=StartBrowser.parenttest.createNode("Verify Dashboard Header");
        commonFunctions.AssertText(logoSauceDemo, "Header",expectedText);

    }
}
