package com.vytrack.test.homework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_5 extends TestBase {

    @Test
    public void TestCase5() {

        extentLogger = report.createTest("Verify that all calendar events were selected");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a Store manager");
        loginPage.loginAsAStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);

        WebElement topCheckBox =driver.findElement(By.xpath("//button/input[1]"));
        BrowserUtils.waitForClickablility(topCheckBox,5);
        extentLogger.info("Click on the top checkbox to select all");
        topCheckBox.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@tabindex='-1']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        extentLogger.pass("PASSED");



    }
}