package com.telran.mobile.tests.test;

import com.telran.mobile.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationFromSidebarTest extends TestBase {

    @Test
    public void createTeam() throws InterruptedException {
        app.getSession().pause(5000);
        int before = app.getTeam().getTeamsCount();
        app.getTeam().selectCreateTeam();
        app.getTeam().fillTeamCreationForm(new Team().
                setTeamName("MyTeam"+System.currentTimeMillis()%100).
                setTeamDescription("La-La-La"));
        app.getTeam().confirmTeamCreation();
        app.getHeader().clickOnHomeButtonOnHeader();
        app.getSession().pause(5000);

        int after = app.getTeam().getTeamsCount();
        System.out.println(before + " : " + after);
        Assert.assertEquals(after, before+1);
    }
/*
    @AfterClass
    public void postAction() throws InterruptedException {
        app.getTeam().cleanTeams();
    }
*/
}
