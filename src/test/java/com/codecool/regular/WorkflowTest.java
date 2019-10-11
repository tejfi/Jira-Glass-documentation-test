package com.codecool.regular;

import Pages.Login;
import Util.WebdriverSingleton;
import org.junit.jupiter.api.*;
import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;


public class WorkflowTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        WebdriverSingleton.dotEnvLoader();
        Login login = new Login(WebdriverSingleton.getDriver());
        login.goToPage();
        login.doLogin(System.getenv("JIRA_USERNAME"), System.getenv("JIRA_PASSWORD"));
    }

    @Test
    public void test1() {

    }


    @AfterEach
    public void afterTest() {
        WebdriverSingleton.closeWebBrowser();
    }

}