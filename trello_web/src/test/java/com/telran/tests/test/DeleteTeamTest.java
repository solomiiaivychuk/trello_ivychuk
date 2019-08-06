package com.telran.tests.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTeamTest extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getTeam().isTeamPresent()) {
            new CreateTeamTest().createTeam();
        }
    }

    @Test
    public void deleteTeam() throws InterruptedException {
        int before = app.getTeam().getTeamsCount();
        app.getTeam().clickOnFirstTeam();
        app.getTeam().clickOnSettings();
        app.getTeam().clickOnDeleteTeam();
        app.getTeam().confirmTeamDeletion();
        app.getPage().clickOnHomeButtonOnHeader();
        int after = app.getTeam().getTeamsCount();
        System.out.println(before + " : " + after);
        Assert.assertEquals(after, before-1);
    }
}
