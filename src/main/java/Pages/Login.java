package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage {
    @FindBy(id = "login-form-username")
    WebElement usernameField;
    @FindBy(id = "login-form-password")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement btnSubmit;
    @FindBy(xpath = "//a[@id='header-details-user-fullname']")
    WebElement userProfile;
    @FindBy(id = "log_out")
    WebElement logoutBtn;


    public Login(WebDriver driver) {
        super("/secure/Dashboard.jspa", driver);
    }

    public void doLogin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        btnSubmit.
                click();
    }

    public void clickOnProfileImg() {
        userProfile.click();
    }

    public boolean validateProfileImgIsPresent(String logout) {
        return logoutBtn.getText().equals(logout);
    }

    public void logOut() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", userProfile);
        executor.executeScript("arguments[0].click();", logoutBtn);


        WebDriverWait webDriverwait = new WebDriverWait(driver, 10);
       /* WebElement userProfile = webDriverwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='header-details-user-fullname']")));
        userProfile
                .click();*/
        /*WebElement logoutButton = webDriverwait.until(ExpectedConditions.elementToBeClickable(By.id("log_out")));

        logoutButton.
                click();*/
    }

}

