package com.codecool;

import Pages.Login;
import Util.WebdriverSingleton;
import org.junit.jupiter.api.*;
import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;


public class WorkflowTest {
    private WebDriver driver;
    Map<String, String> dotEnv;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        dotEnv = WebdriverSingleton.dotEnvLoader();
        Login login = new Login(WebdriverSingleton.getDriver());
        login.goToPage();
        login.doLogin(System.getenv("JIRA_USERNAME"), System.getenv("JIRA_PASSWORD"));
    }

    @Test
    public void test1(){

    }



    @AfterEach
    public void afterTest() {
        WebdriverSingleton.closeWebBrowser();
    }

}