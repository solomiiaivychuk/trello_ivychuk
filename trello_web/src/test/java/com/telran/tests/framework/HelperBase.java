package com.telran.tests.framework;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/*
методи, що не прив'язані ні до яких класів
системні
 */
public class HelperBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);
    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void attach (By locator, File file) {
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void takeScreenshot() throws IOException {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test/Screenshots/Screenshot-" + System.currentTimeMillis() + ".png");
        Files.copy(tmp, screenshot);
        logger.info("-----------------------------------------------");
        logger.info("Screenshot was taken - " + screenshot.getName());
    }
}
