package com.vytrack.test.homework;

import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.testng.annotations.Test;

public class TestCase_5 extends TestBase {

    @Test
    public void TestCase5(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsAStoreManager();


    }


}
