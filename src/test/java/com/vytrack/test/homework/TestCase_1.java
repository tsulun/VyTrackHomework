package com.vytrack.test.homework;

import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.testng.annotations.Test;

public class TestCase_1 extends TestBase {
    @Test
    public void testCase1(){
    LoginPage testCaseObject = new LoginPage();
    testCaseObject.loginAsAStoreManager();


    }
}
