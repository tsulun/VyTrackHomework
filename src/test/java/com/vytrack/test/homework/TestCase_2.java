package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_2 extends TestBase {

    @Test
    public void verifyPageNumber() {

        extentLogger = report.createTest("Verify Page Number");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Logged in as a store manager");
        loginPage.loginAsAStoreManager();

        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Navigated to Activities --> Calendar Events");
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        String expectedPageNumber="1";
        String actualPageNumber = calendarEventsPage.getPageNumber();

        extentLogger.info("Compared actual and expected page number");
        Assert.assertEquals(actualPageNumber,expectedPageNumber,"Verify page number");

        extentLogger.pass("PASSED");
    }
}
