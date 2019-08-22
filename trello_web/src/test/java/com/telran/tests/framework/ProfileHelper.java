package com.telran.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class ProfileHelper extends HelperBase {

    public ProfileHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnProfileAndVisibility() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }
    public void moveToImage() {
        WebElement img = driver.findElement(By.xpath("//button[@class='_2e97X7K2YRLv4Q']"));
        new Actions(driver).moveToElement(img).pause(5).click().perform();
    }
    public void clickAttachPicture(File file) {
        attach(By.xpath("//*[@name='file']"), file);
    }
}
