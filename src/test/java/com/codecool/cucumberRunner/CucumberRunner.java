package com.codecool.cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//src/test/java/com/codecool/features", glue = {"com.codecool.steps"}, plugin = "pretty")
public class CucumberRunner {
}
