package com.telran.mobile.tests.model;

public class Team {
    private String teamName;
    private String teamDescription;

    @Override
    public String toString() {
        return "Team : " +
                "teamName : -" + teamName +
                "-, teamDescription : -" + teamDescription + "-";
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
        return this;
    }
}
/*
setters have to return to the starting point - to the class of setter
 */