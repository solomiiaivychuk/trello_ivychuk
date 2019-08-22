package com.telran.mobile.tests.test;

import com.telran.mobile.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TeamCreationFromSidebarTestWithDataProvider extends TestBase {
/*
    @Test (dataProvider = "teams", dataProviderClass = DataProviders.class) //name of iterator
    public void createTeam(Team team) throws InterruptedException {
        app.getSession().pause(5000);
        int before = app.getTeam().getTeamsCount();
        app.getTeam().selectCreateTeam();
        app.getTeam().fillTeamCreationForm(team);
        app.getTeam().confirmTeamCreation();
        app.getHeader().clickOnHomeButtonOnHeader();
        app.getSession().pause(5000);

        int after = app.getTeam().getTeamsCount();
        System.out.println(before + " : " + after);
        Assert.assertEquals(after, before+1);
    }

    @AfterClass(alwaysRun = true)
    public void postAction() throws InterruptedException {
        app.getTeam().cleanTeams();
    }
*/
}
