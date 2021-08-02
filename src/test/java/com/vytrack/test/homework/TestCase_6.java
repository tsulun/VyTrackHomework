package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestCase_6 extends TestBase {
/*
        Test Case #6
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Select “Testers meeting”
    5. Verify that following data is displayed:
     */


    @Test
    public void test06(){

        extentLogger = report.createTest("Verify Calendar - Testers meeting Data");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as Store Manager");
        loginPage.loginAsAStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Click on View Per Page dropdown and select 100");
        calendarEventsPage.selectViewPerPage100();

        calendarEventsPage.getTotalNumberOfPages();

        extentLogger.info("Click on Testers Meeting");
        calendarEventsPage.findMeeting(calendarEventsPage.testersMeeting);

        calendarEventsPage.getMeetingDetails();

        String guests = calendarEventsPage.actualTitleAndDescription.get("Guests");
        String[] splitGuest = guests.split(" -");
        String newGuest = splitGuest[0];
        calendarEventsPage.actualTitleAndDescription.replace("Guests", newGuest);

        calendarEventsPage.getExcelDetails("src/test/resources/TestersMeeting.xlsx","Sheet1");

        String keyActual = "";
        String keyExpected = "";

        extentLogger.info("Verify Testers Meeting data");
        for (String eachkeyActual : new ArrayList<>(calendarEventsPage.actualTitleAndDescription.keySet())) {
            keyActual = calendarEventsPage.actualTitleAndDescription.get(eachkeyActual);
            calendarEventsPage.actualTitleAndDescription.remove(eachkeyActual);
            for (String eachkeyExpected : new ArrayList<>(calendarEventsPage.expectedTitleAndDescription.keySet())) {
                keyExpected = calendarEventsPage.expectedTitleAndDescription.get(eachkeyExpected);
                calendarEventsPage.expectedTitleAndDescription.remove(eachkeyExpected);
                break;
            }

            Assert.assertEquals(keyActual,keyExpected);

        }

        extentLogger.pass("PASSED");
    }
}

