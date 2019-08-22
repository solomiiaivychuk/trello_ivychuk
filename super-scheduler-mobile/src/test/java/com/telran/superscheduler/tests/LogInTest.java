package com.telran.superscheduler.tests;

import com.telran.superscheduler.TestBase;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    @Test
    public void testLogIn() throws InterruptedException {
        app.getSession().pause(5000);
        app.getSession().fillLoginForm("tester28490@gmail.com", "Password1");
        app.getSession().closeKeyboard();
        app.getSession().clickLoginButton();
        app.getSession().pause(5000);
    }
}
