package com.telran.trello_mobile_new.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("user"), email);
        type(By.id("password"), password);
    }

    public void clickLoginButton() {
        click(By.id("log_in_button"));
    }

    public void confirmLogIn() {
        click(By.id("authenticate"));
    }
}

