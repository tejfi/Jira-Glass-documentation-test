package com.codecool.steps;

import Pages.Project;
import Util.WebdriverSingleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.Assert;


import java.net.MalformedURLException;
import java.security.PrivateKey;

public class Counter {
    private Project project = new Project("https://jira2.codecool.codecanvas.hu/secure/BrowseProjects.jspa?selectedCategory=all&selectedProjectType=all", WebdriverSingleton.getDriver());

    public Counter() throws MalformedURLException {

    }

    @Given("Ensure user on the site")
    public void ensureUserOnTheSite() {
        String actual = project.getHeaderSectionText();
        Assert.assertEquals(WebdriverSingleton.dotEnvLoader().get("HEADER_TEXT"), actual);


    }


    @And("Select project from the dropdown menu")
    public void selectProjectFromTheDropdownMenu() {
        project.getJiraProjectPage();
    }

    @Then("project title shown on the  left side bar")
    public void projectTitleShownOnTheLeftSideBar() {
        Assert.assertTrue(project.checkProjectIsShownOnTheLeftSide());
    }

    @When("Select GLASS DUCOMENTATION on the left  side bar")
    public void selectGLASSDUCOMENTATIONOnTheLeftSideBar() {
        project.getGlassDucoments();
    }

    @Then("glass-navigation bar will shown")
    public void glassNavigationBarWillShown() {
        Assert.assertNotNull(project.checkGlassNavigationbar());
    }

    @When("Click on PROJECTS from the menu bar")
    public void clickOnPROJECTSFromTheMenuBar() {
        project.getProjects();
    }
}
