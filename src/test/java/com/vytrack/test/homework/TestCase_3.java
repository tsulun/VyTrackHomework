package com.vytrack.test.homework;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_3 extends TestBase {

@Test
    public void loginAsStoreManager(){

    LoginPage loginPage = new LoginPage();
    loginPage.loginAsAStoreManager();

    DashboardPage dashboardPage = new DashboardPage();

    dashboardPage.waitUntilLoaderScreenDisappear();

    dashboardPage.navigateToModule("Activities","Calendar Events");

    DashboardPage dash = new DashboardPage();

    String actual = dash.getPageNum();
    String expected = "25";

    Assert.assertEquals(actual,expected,"verify page number is 25");







}




}
