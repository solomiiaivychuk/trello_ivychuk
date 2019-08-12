package com.telran.tests.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AvatarChangingTest extends TestBase {
    @BeforeMethod
    public void preConditions() throws IOException {
        app.getSession().takeScreenshot();
    }

    @Test
    public void changeAvatar() throws InterruptedException {
    app.getSession().clickOnAvatarOnHeader();
    app.getSession().clickOnProfileAndVisibility();
    app.getSession().moveToImage();
    app.getSession().clickAttachPicture(new File("src\\test\\resources\\racoon.jpg"));
    app.getPage().clickOnHomeButtonOnHeader();
    }

    @AfterMethod
    public void postActions() throws IOException {
        app.getSession().takeScreenshot();
    }
}
