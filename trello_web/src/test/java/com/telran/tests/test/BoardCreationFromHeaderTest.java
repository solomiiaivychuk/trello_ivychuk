package com.telran.tests.test;

import com.telran.tests.model.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BoardCreationFromHeaderTest extends TestBase {
    @Test
    public void boardCreationTestFromHeader() throws InterruptedException {
        int beforeCreation = app.getBoard().getBoardsCount();
        app.getPage().clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropdown();
        app.getBoard().fillBoardCreationForm(new Board("Masa" + System.currentTimeMillis() % 100));
        app.getBoard().confirmBoardCreation();
        app.getPage().clickOnHomeButtonOnHeader();
        app.getBoard().pause(5000);

        int afterCreation = app.getBoard().getBoardsCount();

        System.out.println(beforeCreation + " : " + afterCreation);

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }
    /*
    @AfterClass
    public void postAction() throws InterruptedException {
        app.getBoard().cleanBoards();
    }
    */
}

