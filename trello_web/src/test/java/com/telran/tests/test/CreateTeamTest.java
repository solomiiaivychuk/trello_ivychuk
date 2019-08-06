package com.telran.tests.test;

import com.telran.tests.framework.TestBase;
import org.testng.annotations.Test;

public class CreateTeamTest extends TestBase {

    @Test
    public void createTeam() throws InterruptedException {
        app.getSession().pause(5000);
        int before = app.getTeam().getTeamsCount();
        app.getSession().pause(5000);
        app.getTeam().selectCreateTeam();
        app.getTeam().fillTeamCreationForm("MySuperTeam" + System.currentTimeMillis()%100000000000000000l, "La-La-La");
        app.getTeam().confirmTeamCreation();
        app.getPage().clickOnHomeButtonOnHeader();
        app.getSession().pause(5000);

        int after = app.getTeam().getTeamsCount();
        System.out.println(before + " : " + after);
    }
}
