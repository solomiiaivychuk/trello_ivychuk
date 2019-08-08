package com.telran.tests.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBoardFromHome extends TestBase {

    @Test
    public void deleteBoardFromHome() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().clickOnFirstBoard();
        app.getBoard().clickOnMoreButtonInBoardMenu();
        app.getBoard().chooseCloseBoard();
        app.getBoard().confirmClosingBoard();
        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().confirmPermanentBoardDeletion();
        app.getPage().clickOnHomeButtonOnHeader();
        app.getSession().pause(5000);
        int after = app.getBoard().getBoardsCount();

        System.out.println(before + " : " + after);
        Assert.assertEquals(before, after+1);

    }

}
