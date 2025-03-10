package com.telran.mobile.tests.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionFromSidebarTest extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getTeam().isTeamPresent()) {
            new TeamCreationFromSidebarTest().createTeam();
        }
    }

    @Test
    public void deleteTeam() throws InterruptedException {
        int before = app.getTeam().getTeamsCount();
        app.getTeam().clickOnFirstTeam();
        app.getSession().pause(1000);
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeam();
        app.getTeam().confirmTeamDeletion();
        app.getHeader().clickOnHomeButtonOnHeader();
        int after = app.getTeam().getTeamsCount();
        System.out.println(before + " : " + after);
        Assert.assertEquals(after, before-1);
    }
}
