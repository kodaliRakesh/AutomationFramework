package org.infinite.scripts;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.infinite.config.StartBrowser;
import org.infinite.pages.LogOutPage;
import org.infinite.pages.LoginPage;
import org.testng.annotations.Test;

public class ReadingFromExcel extends StartBrowser {
    @Test
    public void excel() throws Exception {
        LoginPage loginPage=new LoginPage();
        LogOutPage logOutPage=new LogOutPage();
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("TestData/Data.xlsx");
        String query="select * from Data";
        Recordset recordSet=connection.executeQuery(query);

        while (recordSet.next()){
            loginPage.login(recordSet.getField("username"), recordSet.getField("password"));
        }

        loginPage.assertDashboard("Swag Labs");
        logOutPage.LogOut();
    }


}
