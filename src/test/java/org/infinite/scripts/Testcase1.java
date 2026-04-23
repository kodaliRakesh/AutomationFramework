package org.infinite.scripts;

import org.infinite.config.StartBrowser;
import org.infinite.functions.LoginFunctions;
import org.infinite.pages.LogOutPage;
import org.infinite.pages.LoginPage;
import org.testng.annotations.Test;

public class Testcase1 extends StartBrowser {
    @Test
    public void sauceapplicationlogin() throws Exception {
        LoginPage loginPage=new LoginPage();
        LogOutPage logOutPage=new LogOutPage();
        loginPage.login();
        System.out.println("Page launched");
        loginPage.assertDashboard("Swag Labs");
        logOutPage.LogOut();
        System.out.println("Executed successfully");
    }


}
