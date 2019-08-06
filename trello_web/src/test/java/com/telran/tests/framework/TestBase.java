package com.telran.tests.framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

   public ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException{
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
