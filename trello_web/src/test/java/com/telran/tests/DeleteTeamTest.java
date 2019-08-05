package com.telran.tests;

import org.testng.annotations.Test;

public class DeleteTeamTest extends TestBase {
    
    @Test
    public void deleteTeam() {
        clickOnFirstTeam();
        clickOnSettings();
        clickOnDeleteTeam();
        confirmTeamDeletion();
        
    }

    private void confirmTeamDeletion() {
    }

    private void clickOnDeleteTeam() {
        
    }

    private void clickOnSettings() {
        
    }

    private void clickOnFirstTeam() {
        
    }
}
