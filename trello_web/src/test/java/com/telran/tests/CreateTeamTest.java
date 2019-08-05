package com.telran.tests;

import org.testng.annotations.Test;

public class CreateTeamTest extends TestBase {

    @Test
    public void createTeam() throws InterruptedException {
        app.getSession().pause(5000);
        int before = app.getTeam().getTeamsCount();
        app.getSession().pause(5000);
        System.out.print(before + " : ");
        app.getTeam().selectCreateTeam();
        app.getTeam().fillTeamCreationForm("MySuperTeam" + System.currentTimeMillis()%100000000000000000l, "La-La-La");
        app.getTeam().confirmTeamCreation();
        app.getSession().pause(5000);

        int after = app.getTeam().getTeamsCount();
        System.out.println(after);
    }
}
