package Pages;

import Util.WebdriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project extends BasePage {

    public Project(String route, WebDriver driver) {
        super(route, driver);
    }

    @FindBy(xpath = "//ul[@id='header-nav']")
    WebElement glassNavBar;
    @FindBy(linkText = "weLoveJira (WEL)")
    WebElement desiredProject;
    @FindBy(xpath = "section[@id='content']//h1[.='Browse projects']")
    WebElement headerSection;
    @FindBy(xpath = "//a[@id='browse_link']")
    WebElement browseLink;
    @FindBy(xpath = "//div[@class='aui-item project-title']/a[@title]")
    WebElement projectTitle;
    @FindBy(xpath = "//span[@title='Glass Documentation']")
    WebElement glassDucomentation;
    @FindBy(xpath = "//a[@data-tooltip='Project settings']")
    WebElement projectSettings;
    @FindBy(xpath = "//div[@class='aui-page-header-main']//h1[@id='project-config-header-name']")
    WebElement projectSettingsTitle;
    @FindBy(xpath = "//a[@id='view_project_workflows']")
    WebElement workFlowLink;

    public void getJiraProjectPage() {
        desiredProject.click();
    }

    public String getHeaderSectionText() {
        return headerSection.getText();
    }

    public void getProjects() {
        browseLink.click();
    }

    public boolean checkProjectIsShownOnTheLeftSide() {
/*
        String actualprojectTitle = projectTitle.getText();
*/
        WebDriverWait webDriverwait = new WebDriverWait(driver, 10);
        WebElement projectTitle = webDriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='aui-item project-title']/a[@title]")));
        String actualprojectTitle = projectTitle
                .getText();
        return actualprojectTitle.equals(WebdriverSingleton.dotEnvLoader().get("PROJECT_TITLE"));

    }

    public void getGlassDucoments() {
        glassDucomentation.click();
    }


    public Object checkGlassNavigationbar() {
        return glassNavBar.isDisplayed();

    }

    public void goToProjectSettings() {
        projectSettings.click();
    }

    public boolean validUserOnTheProjectSettingsPage() {

        return projectSettingsTitle.isDisplayed();
    }

    public void goToWorkFlow() {
        workFlowLink.click();
    }
}
