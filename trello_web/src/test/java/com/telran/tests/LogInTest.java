package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTest extends TestBase {

    @Test
    public void loginTest() throws InterruptedException {
        clickOnLoginButton();
        fillUserForm("tester28490@gmail.com", "Password234");
        clickOnLoginButton();
        pause(20000);
    }
}
