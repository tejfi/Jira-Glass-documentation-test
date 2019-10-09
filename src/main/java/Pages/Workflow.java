package Pages;

import Util.WebdriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Workflow extends BasePage {
    private WebDriver webDriver;

    public Workflow(String route, WebDriver driver) {
        super(route, driver);
    }


    @FindBy(id = "project-config-header-name")
    WebElement projectSettingsHeader;
    @FindBy(xpath = "//div[@class='aui-page-header-main']/h2[@class='project-config-heading']")
    WebElement projectConfigHeading;
    @FindBy(xpath = "//button[@id='project-config-workflow-add-dropdown-trigger']")
    WebElement addWorkFlowButton;
    @FindBy(xpath = "//a[@id='project-config-workflow-marketplace-button']")
    WebElement importFromBundleLink;
    @FindBy(xpath = "//div[@class='aui-page-header-main']//h1[contains(text(),'Select a workflow')]")
    WebElement workFLowSelectHeading;
    @FindBy(xpath = "//div[1]/div[@class='aui-item']/div[@class='workflow-description']/form[@action='/plugins/servlet/wfshare-import/wfshare-import']/input[@value='Select']")
    WebElement selectAgileWorkFlowinput;
    @FindBy(xpath = "//input[@name='wfShareWorkflowName']")
    WebElement workFlowNamingField;
    @FindBy(id = "nextButton")
    WebElement nextButton;
    @FindBy(xpath = "//strong[.='Workflow has been successfully imported']")
    WebElement mapWorkFlowStatues;
    @FindBy(xpath = "//section[@class='aui-page-panel-content']/h2[.='Preview of import']")
    WebElement previewOfImport;
    @FindBy(id = "login-form-authenticatePassword")
    WebElement administratorAccesField;
    @FindBy(xpath = "//section[@class='aui-page-panel-content']//h1[.='Administrator Access']")
    WebElement administratorAccesHeading;
    @FindBy(id = "login-form-submit")
    WebElement loginFormSubmit;
    @FindBy(className = "aui-message")
    WebElement succesFullMessage;
    @FindBy(id = "finishButton")
    WebElement finishButton;
    @FindBy(xpath = "//div[@class='jira-dialog-heading']//h2")
    WebElement dialogHeading;
    @FindBy(xpath = "//div[@id='assign-issue-types-dialog']//form[@class='aui']//table//span[@title='Task - A task that needs to be done.']")
    WebElement task;
    @FindBy(id = "assign-issue-types-submit")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='project-config-workflow-name']//a")
    List<WebElement> workflows;
    @FindBy(id = "publish-draft")
    WebElement publishButton;
    @FindBy(xpath = "//section[@class='aui-page-panel-content']//h2")
    WebElement publishH2Tag;
    @FindBy(id = "workflow-mapping-submit")
    WebElement associateButton;
    @FindBy(className = "aui-message aui-message-success success closeable shadowed aui-will-close")
    WebElement auiMessage;


    public boolean checkUserOnTheProjectSettings() {

        return projectSettingsHeader.isDisplayed();
    }

    public boolean checkUserOnTheWorkFlowConfigPage() {
        String actualheadingText = projectConfigHeading.getText();
        return actualheadingText.equals(WebdriverSingleton.dotEnvLoader().get("PROJECT_CONFIG_HEADING"));
    }

    public void clickaddWorkFlowButton() {
        addWorkFlowButton.click();
    }

    public boolean bundleOptionIsShown() {
        return importFromBundleLink.isDisplayed();

    }

    public void goAndImportFromBundleLink() {
        importFromBundleLink.click();
    }

    public boolean workflowSelectHeading() {

        return workFLowSelectHeading.isDisplayed();
    }

    public void selectWorkFlow() {
        selectAgileWorkFlowinput.click();
    }


    public void addNameToTheNewWorkflow(String workflowName) {
        workFlowNamingField.clear();
        workFlowNamingField.sendKeys(workflowName);
        clickNextButton();
    }


    public boolean checkmapWorkFlowStatues() {

        return mapWorkFlowStatues.isDisplayed();
    }


    public void clickNextButton() {
        nextButton.click();
    }


    public boolean CheckpreviewOfImport() {
        return previewOfImport.isDisplayed();
    }

    public void addPasswordtoTheField() {
        administratorAccesField.clear();
        administratorAccesField.sendKeys(WebdriverSingleton.dotEnvLoader().get("JIRA_PASSWORD"));
    }

    public void clickLoginFormSubmitButton() {
        loginFormSubmit.click();
    }

    public boolean checkSuccesFullyMessage() {

        return succesFullMessage.isDisplayed();
    }

    public boolean administratorAccesHeading() {

        return administratorAccesHeading.isDisplayed();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public void dialogHeadingcheck(String name) {
        dialogHeading.getText().contains(name);
    }

    public void selectTask() {
        task.click();
    }

    public void finishAssign() {
        submitButton.click();
    }

    public boolean checkWorkflowisCreated(String workflowName) {
        for (WebElement workflow : workflows) {
            if (workflow.getText().equals(workflowName)) {
                return true;
            }


        }

        return false;
    }

    public void clickPublishButton() {
        publishButton.click();
    }

    public String getPublishWorkflowText() {
        return publishH2Tag.getText();
    }

    public void clickAssociteButton() {
        associateButton.click();
    }

    public boolean auiMEssageIsshown() {

        return auiMessage.isDisplayed();


    }

    public void removeWorkflow(String workflowName) {
        driver.findElement(By.xpath("//a[@title='Remove" + workflowName + "']"));
    }

}


