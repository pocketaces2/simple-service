package com.simpleservice.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, glue = "classpath:com/simpleservice/stepdefs", features = "classpath:com/simpleservice/features")
public class CucumberTestRunnerTest {
}
