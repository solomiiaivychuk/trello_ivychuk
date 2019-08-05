package com.telran.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    HeaderPage page;
    TeamHelper team;
    BoardHelper board;
    SessionHelper session;
    WebDriver driver;

    public void init() throws InterruptedException {
        driver = new ChromeDriver();
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
}
