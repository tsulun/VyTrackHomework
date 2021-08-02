package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_4 extends TestBase {

    @Test
    public void nrOfRowsAndRecords(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");


//        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//        System.out.println(calendarEventsPage.rowsWithoutHeader.size());
//
//        String expectedRecordsNum = "Total Of 1267 Records";
//
//        Assert.assertEquals(calendarEventsPage.rowsWithoutHeader.size(),expectedRecordsNum,"verify the numbers of Rows and Records");


    }




}
