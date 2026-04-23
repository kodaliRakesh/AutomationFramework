package org.infinite.pages;


import org.infinite.commands.ActionDriver;
import org.infinite.config.StartBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
    public WebDriver driver;
    public ActionDriver actionDriver;

    public static By logOutmenu=By.id("react-burger-menu-btn");
    public static  By logOutbButton=By.id("logout_sidebar_link");
    public LogOutPage(){
        driver= StartBrowser.driver;
        actionDriver=new ActionDriver();

    }
    public void LogOut() throws Exception {
        StartBrowser.childtest=StartBrowser.parenttest.createNode("Logout From Application");
        actionDriver.click(logOutmenu,"LogOut Menu" );
        actionDriver.click(logOutbButton,"LogOut Button");

    }

}
