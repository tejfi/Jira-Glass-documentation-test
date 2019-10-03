package com.codecool;

import Pages.Login;
import Util.DriverSetup;
import org.junit.jupiter.api.Test;
import com.github.shyiko.dotenv.DotEnv;

import java.util.Map;


public class WorkflowTest {

    @Test
    public void doLogin() {
        Login login = new Login(DriverSetup.getWebDriver());
        Map<String, String> dotEnv = DotEnv.load();
        login.login(dotEnv.get("JIRA_USERNAME"), dotEnv.get("JIRA_PASSWORD"));
        System.out.println("0");
    }
}
