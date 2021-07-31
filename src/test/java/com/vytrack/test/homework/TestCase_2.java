package com.vytrack.test.homework;

import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.testng.annotations.Test;

public class TestCase_2 extends TestBase {

    @Test
    public void verifyPageNumber() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();
        


    }
}
