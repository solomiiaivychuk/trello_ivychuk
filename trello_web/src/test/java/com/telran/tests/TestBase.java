package com.telran.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

   ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException{
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
