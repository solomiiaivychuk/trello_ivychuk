package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //
        driver.navigate().to("https://trello.com");
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillUserForm(String email, String password) {
        driver.findElement(By.id("user")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void confirmLoginButton() {
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
