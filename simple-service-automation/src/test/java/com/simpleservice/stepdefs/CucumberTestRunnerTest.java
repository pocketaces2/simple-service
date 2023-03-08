package com.simpleservice.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true, 
        glue = "classpath:com/simpleservice/stepdefs",
        features = "classpath:com/simpleservice/features",
        publish = true)
public class CucumberTestRunnerTest {
}
