package com.codecool;

import Pages.Login;
import Util.DriverSetup;
import org.junit.jupiter.api.Test;
import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public class WorkflowTest {
   private WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://192.168.43.223:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
    }


    @Test
    public void doLogin() {
        Login login = new Login(DriverSetup.getWebDriver());
        login.goToPage();
        Map<String, String> dotEnv = DotEnv.load();
        login.login(dotEnv.get("JIRA_USERNAME"), dotEnv.get("JIRA_PASSWORD"));
        System.out.println("0");
    }
}
