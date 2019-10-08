package com.codecool.steps;

import Util.WebdriverSingleton;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.net.MalformedURLException;
import java.util.Map;

public class Auth {

    private Pages.Login login = new Pages.Login(WebdriverSingleton.getDriver());
    private Map<String, String> dotEnv;

    public Auth() throws MalformedURLException {
    }

    @Given("user on the site")
    public void userOnTheSite() {
        login.goToPage();

    }

    @Then("ensure to provide a login form with the following fields USER and PASSWORD")
    public void ensureToProvideALoginFormWithTheFollowingFieldsUSERAndPASSWORD() {
        dotEnv = WebdriverSingleton.dotEnvLoader();
        login.doLogin(dotEnv.get("JIRA_USERNAME"), dotEnv.get("JIRA_PASSWORD"));

    }

    @Then("I close browser")
    public void iCloseBrowser() {
        WebdriverSingleton.closeWebBrowser();
    }


    @Then("I log out")
    public void iLogOut() {
        login.logOut();
    }
}
