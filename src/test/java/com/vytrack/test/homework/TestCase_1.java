package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_1 extends TestBase {
    @Test
    public void testCase_1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.pageSubtitleOptions.isDisplayed(),
                "Verify that page subtitle \"Options\" is displayed");



    }
}
