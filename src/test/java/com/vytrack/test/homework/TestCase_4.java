package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import org.testng.annotations.Test;

public class TestCase_4 {

    @Test
    public void nrOfRowsAndRecords(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();




    }


}
