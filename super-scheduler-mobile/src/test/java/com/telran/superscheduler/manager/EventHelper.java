package com.telran.superscheduler.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EventHelper extends HelperBase{
    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnPlusButton() {
        click(By.id("list_fr_recycler_view"));
    }
}
