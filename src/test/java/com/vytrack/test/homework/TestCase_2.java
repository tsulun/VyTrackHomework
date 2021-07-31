package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_2 extends TestBase {

    @Test
    public void verifyPageNumber() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        String expectedPageNumber="1";
        String actualPageNumber = calendarEventsPage.getPageNumber();

        Assert.assertEquals(actualPageNumber,expectedPageNumber,"Verify page number");

    }
}
