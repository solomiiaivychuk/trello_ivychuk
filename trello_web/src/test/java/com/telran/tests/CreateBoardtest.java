package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateBoardtest extends TestBase {

    @Test
    public void boardCreationTest() throws InterruptedException {
        clickOnLoginButton();
        fillUserForm("tester28490@gmail.com", "Password234");
        confirmLoginButton();
        pause(5000);
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropdown();
        fillBoardCreationForm("MyBoard");
        pause(2000);
        confirmBoardCreation();
        pause(2000);
        addListToBoard();
        inputListTitle("MyFirstList");
        confirmListCreation();
        pause(2000);
        addCard();
        inputCardName("MyCard");
        confirmCardCreation();
        pause(5000);
        clickOnHomeButtonOnHeader();
        pause(10000);
        clickOnAccountButton();
        logOut();
    }
    private void selectCreateBoardFromDropdown() {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }
    private void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[name=add]"));
    }
    private void fillBoardCreationForm(String title) {
        driver.findElement(By.xpath("//input[@placeholder='Add board title']")).sendKeys(title);
    }
    private void confirmBoardCreation() {
    click(By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }
    private void clickOnHomeButtonOnHeader() {
       click(By.xpath("//span[@name='house']"));
   }
    private void addListToBoard() {
        click(By.xpath("//input[@placeholder='Enter list title...']"));
   }
    private void inputListTitle(String listTitle) {
        driver.findElement(By.xpath("//input[@placeholder='Enter list title...']")).sendKeys(listTitle);
   }
    private void confirmListCreation() {
        click(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
   }
    private void addCard() {
        click(By.xpath("//span[@class='js-add-a-card']"));
   }
    private void inputCardName(String cardName) {
        driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys(cardName);
   }
    private void confirmCardCreation() {
        click(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"));
   }
   private void clickOnAccountButton() {
        click(By.xpath("//span[@class='_24AWINHReYjNBf']"));
   }
   private void logOut() {
        click(By.xpath("//span[contains(text(),'Log Out')]"));
   }
}