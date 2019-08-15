package com.telran.tests.framework;

import com.telran.tests.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    HeaderPage page;
    TeamHelper team;
    BoardHelper board;
    SessionHelper session;
    EventFiringWebDriver driver;
    public String browser;

    public class MyListener extends AbstractWebDriverEventListener {
        HelperBase hb = new HelperBase(driver);
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search element " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Element " + by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
            try {
                hb.takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() throws InterruptedException {
        try {
            if (browser.equals(BrowserType.CHROME)) {
                driver = new EventFiringWebDriver(new ChromeDriver());
            } else if (browser.equals(BrowserType.FIREFOX)) {
                driver = new EventFiringWebDriver(new FirefoxDriver());
            } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EventFiringWebDriver(new EdgeDriver());
            }
        } catch (Exception e) {
            System.out.println("Unknown browser format");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com");

        page = new HeaderPage(driver);
        team = new TeamHelper(driver);
        board = new BoardHelper(driver);
        session = new SessionHelper(driver);

        driver.register(new MyListener());
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

    public HeaderPage getPage() {
        return page;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
