package com.codecool.cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//src/test/java/com/codecool/features",
        glue = {"com.codecool.steps"},
        plugin = ("json:target/cucumber-reports/CucumberTestReport.json"),
        monochrome= true,
        dryRun= false)
public class CucumberRunner {
}
