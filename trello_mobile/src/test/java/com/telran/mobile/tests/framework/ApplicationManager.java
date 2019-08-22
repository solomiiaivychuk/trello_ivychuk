package com.telran.mobile.tests.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    HeaderPage header;
    TeamHelper team;
    BoardHelper board;
    SessionHelper session;
    ProfileHelper profile;
    AppiumDriver driver;

    public void init() throws InterruptedException, MalformedURLException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Mi5s");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\Users\\solom\\Documents\\GitHubProjects\\trello_ivychuk\\super-scheduler-mobile\\src\\test\\resources\\v.0.0.2.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        header = new HeaderPage(driver);
        team = new TeamHelper(driver);
        board = new BoardHelper(driver);
        session = new SessionHelper(driver);
        profile = new ProfileHelper(driver);


        session.login("tester28490@gmail.com", "Password234");
    }

    public void stop() {
        driver.quit();
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public HeaderPage getHeader() {
        return header;
    }

    public ProfileHelper getProfile() {
         return profile;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
