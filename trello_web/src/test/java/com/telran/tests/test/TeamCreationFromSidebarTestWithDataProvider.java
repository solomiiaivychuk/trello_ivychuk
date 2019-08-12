package com.telran.tests.test;

import com.telran.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationFromSidebarTestWithDataProvider extends TestBase {

    @Test (dataProvider = "teams", dataProviderClass = DataProviders.class) //name of iterator
    public void createTeam(Team team) throws InterruptedException {
        app.getSession().pause(5000);
        int before = app.getTeam().getTeamsCount();
        app.getTeam().selectCreateTeam();
        app.getTeam().fillTeamCreationForm(team);
        app.getTeam().confirmTeamCreation();
        app.getPage().clickOnHomeButtonOnHeader();
        app.getSession().pause(5000);

        int after = app.getTeam().getTeamsCount();
        System.out.println(before + " : " + after);
        Assert.assertEquals(after, before+1);
    }

    @AfterClass(alwaysRun = true)
    public void postAction() throws InterruptedException {
        app.getTeam().cleanTeams();
    }

}
