package com.vytrack.test;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import org.testng.annotations.Test;

public class JamalHomework extends TestBase {
    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsASalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Customers","Contacts");

    }
}
