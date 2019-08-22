package com.telran.trello_mobile_new.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {

    SessionHelper session;

    EventHelper event;
    AppiumDriver driver;

    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Mi5s");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\Users\\solom\\Documents\\GitHubProjects\\trello_ivychuk\\trello_mobile_new\\src\\test\\resources\\trello.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        session = new SessionHelper(driver);
        event = new EventHelper(driver);

        //session.login("tester28490@gmail.com", "Password234");
    }
    public void stop() {
        driver.quit();
    }

    public SessionHelper getSession() {
        return session;
    }
    public EventHelper getEvent() {
        return event;
    }
}
