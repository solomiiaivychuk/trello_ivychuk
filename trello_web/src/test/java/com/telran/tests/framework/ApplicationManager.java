package com.telran.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    HeaderPage page;
    TeamHelper team;
    BoardHelper board;
    SessionHelper session;
    WebDriver driver;
    public String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() throws InterruptedException {
        try {
            if (browser.equals(BrowserType.CHROME)) {
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                driver = new FirefoxDriver();
            } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EdgeDriver();
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
