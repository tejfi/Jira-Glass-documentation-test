package com.codecool.steps;

import Pages.Project;
import Pages.Workflow;
import Util.WebdriverSingleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;

public class WorkflowSteps {
    private Workflow workflow = new Workflow("plugins/servlet/project-config/WEL/workflows", WebdriverSingleton.getDriver());
    private Project project = new Project("plugins/servlet/project-config/WEL/summary", WebdriverSingleton.getDriver());

    public WorkflowSteps() throws MalformedURLException {
    }


    @Then("Validate user on the PROJECT SETTINGS page")
    public void validateUserOnThePROJECTSETTINGSPage() {
        Assert.assertTrue(workflow.checkUserOnTheProjectSettings());
    }

    @When("Click on Workflows link on the left side bar")
    public void clickOnWorkflowsLinkOnTheLeftSideBar() {
        project.goToWorkFlow();
    }

    @Then("Workflow project config Header will shown")
    public void workflowProjectConfigHeaderWillShown() {
        workflow.checkUserOnTheWorkFlowConfigPage();
    }

    @When("ADD WORKFLOW button is clicked")
    public void addWORKFLOWButtonIsClicked() {
        workflow.clickaddWorkFlowButton();
    }

    @Then("import FROM BUNDLE option is shown")
    public void importFROMBUNDLEOptionIsShown() {
        workflow.bundleOptionIsShown();
    }

    @When("import FROM BUNDLE option is clicked")
    public void importFROMBUNDLEOptionIsClicked() {
        workflow.goAndImportFromBundleLink();

    }

    @Then("SELECTION OF WORKFLOWS are shown")
    public void selectionOFWORKFLOWSAreShown() {
        workflow.workflowSelectHeading();
    }


    @And("Add name to the Worfklow {string}")
    public void addNameToTheWorfklow(String workflowName) {
        workflow.addNameToTheNewWorkflow(workflowName);
    }

    @When("click NEXT button")
    public void clickNEXTButton() {
        workflow.clickNextButton();
    }

    @Then("Map Workflow Statuses will be shown")
    public void mapWorkflowStatusesWillBeShown() {
        if (administratorACCESWillShown()) {
            ensureUserEnteredValidPassword();
            clickedTheSubmitButton();

        } else {
            workflow.checkmapWorkFlowStatues();

        }

    }

    @Then("Preview of Import will shown")
    public void previewOfImportWillShown() {

    }

    @When("click next button")
    public void clickNextButton() {
        clickedTheSubmitButton();
    }

    @Then("ADMINISTRATOR ACCES will shown")
    public boolean administratorACCESWillShown() {

        return workflow.administratorAccesHeading();
    }

    @And("ensure user entered valid password")
    public void ensureUserEnteredValidPassword() {
        workflow.addPasswordtoTheField();
    }

    @And("clicked the Submit button")
    public void clickedTheSubmitButton() {
        workflow.clickLoginFormSubmitButton();
    }

    @Then("Workflow has been successfully imported message will shown")
    public void workflowHasBeenSuccessfullyImportedMessageWillShown() {
        workflow.checkSuccesFullyMessage();
    }

    @And("click the FINISH button")
    public void clickTheFINISHButton() {
        workflow.clickFinishButton();
    }

    @Then("DIALOG MESSAGE shown contains {string}")
    public void dialogMESSAGEShownContains(String workFlowName) {
        workflow.dialogHeadingcheck(workFlowName);
    }

    @And("select task")
    public void selectTask() {
        workflow.selectTask();
    }

    @And("Click submit button")
    public void clickSubmitButton() {
        workflow.finishAssign();
    }

    @And("check Worflow is avaiable")
    public void checkWorflowIsAvaiable() {
    }


    @When("Select PROJECT SETTINGS bottom of the left side")
    public void selectPROJECTSETTINGSBottomOfTheLeftSide() {
        project.goToProjectSettings();
    }

    @And("check Worflow is avaiable {string}")
    public void checkWorflowIsAvaiable(String WorkflowName) {
        workflow.checkWorkflowisCreated(WorkflowName);

    }

    @When("select Easy Agile Scrum Workflow for Jira bundle")
    public void selectEasyAgileScrumWorkflowForJiraBundle() {
        workflow.selectWorkFlow();

    }

    @When("click the PUBLISH button")
    public void clickThePUBLISHButton() {
        workflow.clickPublishButton();
    }


    @When("click the Associate button")
    public void clickTheAssociateButton() {
        workflow.clickAssociteButton();
    }

    @Then("Your workflows have been published message shown.")
    public void yourWorkflowsHaveBeenPublishedMessageShown() {
        Assert.assertTrue(workflow.auiMEssageIsshown());
    }

    @When("click remove <{string}>  under the actions")
    public void clickRemoveUnderTheActions(String workflowName) {
        if (administratorACCESWillShown()) {
            ensureUserEnteredValidPassword();
            clickedTheSubmitButton();
        }
        workflow.removeWorkflow(workflowName);
    }


    @Then("<{string}>shown will shwon on the left side")
    public void shownWillShwonOnTheLeftSide(String name) {
        String actual = workflow.getPublishWorkflowText();
        Assert.assertEquals(name, actual);

    }
}
