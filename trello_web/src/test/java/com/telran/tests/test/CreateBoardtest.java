package com.telran.tests.test;

import com.telran.tests.framework.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardtest extends TestBase {

    @Test
    public void boardCreationTestFromHeader() throws InterruptedException {
        int beforeCreation = app.getBoard().getBoardsCount();
        app.getPage().clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropdown();
        app.getBoard().fillBoardCreationForm("Masa" + System.currentTimeMillis()%10000000000000l);
        app.getBoard().confirmBoardCreation();
        app.getPage().clickOnHomeButtonOnHeader();
        app.getBoard().pause(5000);

        int afterCreation = app.getBoard().getBoardsCount();

        System.out.println(beforeCreation + " : " + afterCreation);

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }
}