package com.telran.mobile.tests.test;

import com.telran.mobile.tests.framework.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        logger.info("Start " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod (alwaysRun = true)
    public void stopLogger(Method m) {
        logger.info("Stop " + m.getName());
    }

   public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() throws InterruptedException{
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
