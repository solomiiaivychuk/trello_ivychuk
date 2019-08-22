package com.telran.mobile.tests.framework;

import com.telran.mobile.tests.model.Board;
import com.telran.mobile.tests.test.BoardDeletionFromHome;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BoardHelper extends HelperBase {
    public BoardHelper(AppiumDriver driver) {
        super(driver);
    }

    public void selectCreateBoardFromDropdown() {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), board.getBoardName());
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public int getBoardsCount() {
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void clickOnBoardButtonOnHeader() {
        click(By.xpath("//div[@class='all-boards']//div[2]//ul[1]//li[1]"));
    }
    public void clickOnFirstBoard() throws InterruptedException {
        pause(2000);
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void clickOnMoreButtonInBoardMenu() {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
    }

    public void chooseCloseBoard() {
        click(By.cssSelector(".js-close-board"));
    }

    public void confirmClosingBoard() {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector("[class='quiet js-delete']"));
    }

    public void confirmPermanentBoardDeletion() {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void cleanBoards() throws InterruptedException {
        int before = getBoardsCount();
        while (before > 4) {
            new BoardDeletionFromHome().deleteBoardFromHome();
            before = getBoardsCount();

        }
    }
    public boolean isBoardPresent() {
        return isElementPresent((By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
    }
}
