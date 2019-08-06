package com.telran.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamHelper extends HelperBase {
    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        //for deleting
        //new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.id("org-display-name"), teamName);
        type(By.id("org-desc"), description);
    }

    public void selectCreateTeam() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public int getTeamsCount() {
        WebElement teamsList = driver.findElement(By.cssSelector("nav.home-left-sidebar-container .js-react-root"));
        return teamsList.findElements(By.xpath(".//li")).size();
    }
}
