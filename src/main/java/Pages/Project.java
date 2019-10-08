package Pages;

import Util.WebdriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Project extends BasePage {
    public Project(String route, WebDriver driver) {
        super(route, driver);
    }


    @FindBy(linkText = "weLoveJira (WEL)")
    WebElement desiredProject;
    @FindBy(xpath = "section[@id='content']//h1[.='Browse projects']")
    WebElement headerSection;
    @FindBy(xpath = "//a[@id='browse_link']")
    WebElement browseLink;
    @FindBy(xpath = "//div[@class='aui-item project-title']/a[@title]")
    WebElement projectTitle;

    public void getJiraProjectPage() {
        desiredProject.click();
    }

    public String getHeaderSectionText() {
        return headerSection.getText();
    }

    public void getProjects(){
        browseLink.click();
    }

    public boolean checkProjectIsShownOnTheLeftSide() {
        String actualprojectTitle = projectTitle.getText();

        return actualprojectTitle.equals(WebdriverSingleton.dotEnvLoader().get("PROJECT_TITLE"));

    }


}
