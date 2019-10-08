package Pages;

import Util.WebdriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Workflow extends BasePage {
    public Workflow(String route, WebDriver driver) {
        super(route, driver);
    }

    @FindBy(xpath = "//div[@class='aui-page-header-main']/h2[@class='project-config-heading']")
    WebElement projectConfigHeading;
    @FindBy(xpath = "//button[@id='project-config-workflow-add-dropdown-trigger']")
    WebElement addWorkFlowButton;
    @FindBy(xpath = "//a[@id='project-config-workflow-marketplace-button']")
    WebElement importFromBundleLink;
    @FindBy(xpath = "//div[@class='aui-page-header-main']//h1[contains(text(),'Select a workflow')]")
    WebElement workFLowSelectHeading;
    @FindBy(xpath = "//div[@id='workflowBundleListContainer']/div[1]/div[@class='aui-item']/div[@class='workflow-description']/form[@action='/plugins/servlet/wfshare-import/wfshare-import']/input[@value='Select'")
    WebElement selectAgileWorkFlowinput;
    @FindBy(xpath = "//input[@name='wfShareWorkflowName']")
    WebElement workFlowNamingField;
    @FindBy(id = "nextButton")
    WebElement nextButton;
    @FindBy(xpath = "//section[@class='aui-page-panel-content']/h2[.='Map Workflow Statuses'")
    WebElement mapWorkFlowStatues;
    @FindBy(xpath = "//section[@class='aui-page-panel-content']/h2[.='Preview of import']")
    WebElement previewOfImport;
    @FindBy(id = "login-form-authenticatePassword")
    WebElement administratorAccesField;
    @FindBy(xpath = "//section[@class='aui-page-panel-content']//h1[.='Administrator Access']")
    WebElement administratorAccesHeading;
    @FindBy(id = "login-form-submit")
    WebElement loginFormSubmit;
    @FindBy(xpath = "/section[@id='content']//section[@class='aui-page-panel-content']//strong[.='Workflow has been successfully imported']")
    WebElement succesFullMessage;
    @FindBy(id="finishButton")
    WebElement finishButton;
    @FindBy(xpath = "//div[@class='jira-dialog-heading']//h2")
    WebElement dialogHeading;

    public boolean checkUserOnTheWorkFlowConfigPage() {
        String actualheadingText = projectConfigHeading.getText();
        return actualheadingText.equals(WebdriverSingleton.dotEnvLoader().get("Workflows"));
    }

    public void clickaddWorkFlowButton() {
        addWorkFlowButton.click();
    }

    public boolean bundleOprtionisShown() {
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


    public void addNameToTheNewWorkflow(String name) {
        workFlowNamingField.clear();
        workFlowNamingField.sendKeys(name);
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

    public void  clickFinishButton(){
        finishButton.click();
    }

    public  void dialogHeadingcheck(String name){
        dialogHeading.getText().contains(name);
    }
}
