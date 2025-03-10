package com.telran.mobile.tests.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getSession().logout();
    }

    @Test
    public void loginTest() throws InterruptedException {
        String currentUrl = app.getUrl();
        Assert.assertEquals(currentUrl, "https://trello.com/logged-out");
        app.getSession().clickOnLoginButton();
        app.getSession().fillUserForm("tester28490@gmail.com", "Password234");
        app.getSession().confirmLoginButton();
        app.getHeader().clickOnHomeButtonOnHeader();
        app.getSession().pause(4000);

        Assert.assertTrue(app.getSession().isUserLoggedIn());
    }
}
