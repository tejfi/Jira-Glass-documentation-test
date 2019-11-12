package com.codecool.cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.codecool.steps"},
        features = {".//src/test/java/com/codecool/features"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-reports/cucumber.json"})

public class CucumberRunner {
}
