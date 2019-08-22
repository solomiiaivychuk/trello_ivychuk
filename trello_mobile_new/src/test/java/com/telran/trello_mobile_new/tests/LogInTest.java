package com.telran.trello_mobile_new.tests;

import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    @Test
    public void testLogIn() throws InterruptedException {
        app.getSession().pause(5000);
        app.getSession().clickLoginButton();
        app.getSession().fillLoginForm("tester28490@gmail.com", "Password234");
        //app.getSession().closeKeyboard();
        app.getSession().confirmLogIn();
        app.getSession().pause(5000);
    }
}
