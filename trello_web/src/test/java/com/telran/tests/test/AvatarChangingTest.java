package com.telran.tests.test;

import org.testng.annotations.Test;

public class AvatarChangingTest extends TestBase {

    @Test
    public void changeAvatar() throws InterruptedException {
    app.getSession().clickOnAvatarOnHeader();
    app.getSession().clickOnProfileAndVisibility();
    app.getSession().moveToImage();
    app.getSession().clickUploadPicture();
    app.getSession().pause(2000);
}
}
