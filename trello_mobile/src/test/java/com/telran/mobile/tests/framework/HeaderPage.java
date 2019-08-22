package com.telran.mobile.tests.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends HelperBase {
    public HeaderPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[name=add]"));
    }

    public void clickOnHomeButtonOnHeader() throws InterruptedException {
        pause(2000);
        click(By.cssSelector("a [name='house']"));
        click(By.cssSelector("a [name='house']"));
   }
    public void clickOnAvatarOnHeader() {
        click(By.cssSelector(".js-open-header-member-menu"));
    }
}
