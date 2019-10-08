package com.codecool.steps;

import Pages.Workflow;
import Util.WebdriverSingleton;

import java.net.MalformedURLException;

public class WorkflowSteps {
    private Workflow workflow = new Workflow("plugins/servlet/project-config/WEL/workflows", WebdriverSingleton.getDriver());
    public WorkflowSteps() throws MalformedURLException {
    }
}
