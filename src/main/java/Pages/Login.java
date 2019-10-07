package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage {
    @FindBy(id = "login-form-username")
    WebElement usernameField;
    @FindBy(id = "login-form-password")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement btnSubmit;
    @FindBy(xpath = "//a[@id='header-details-user-fullname']/span/span/img")
    WebElement userProfile;
    @FindBy(id = "log_out")
    WebElement logoutBtn;


    public Login(WebDriver driver) {
        super("/secure/Dashboard.jspa", driver);
    }

    public void doLogin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        btnSubmit.click();
    }

    public void clickOnProfileImg() {
        userProfile.click();
    }

    public boolean validateProfileImgIsPresent(String logout) {
        return logoutBtn.getText().equals(logout);
    }
}

