package com.telran.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        clickOnLoginButton();
        fillUserForm(email, password);
        confirmLoginButton();
        pause(5000);
    }
    public void logout() {
        if(isUserLoggedIn()) {
            clickOnAvatarOnHeader();
            clickLogOut();
        }
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillUserForm(String email, String password) {
        type(By.id("user"), email);
        type(By.id("password"), password);
    }

    public void confirmLoginButton() {
        click(By.id("login"));
    }

    public boolean isUserLoggedIn() {
        return isElementsPresent(By.cssSelector(".js-open-header-member-menu"));
    }
    public void clickLogOut() {
        click(By.xpath("//*[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatarOnHeader() {
        click(By.cssSelector(".js-open-header-member-menu"));
    }

    public void clickOnProfileAndVisibility() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }
    public void moveToImage() {
        WebElement img = driver.findElement(By.xpath("//button[@class='_2e97X7K2YRLv4Q']"));
        new Actions(driver).moveToElement(img).pause(5).click().perform();
    }
    public void clickUploadPicture() {
        click(By.cssSelector("[name='attachment']"));
    }

}
