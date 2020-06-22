package com.bkteam;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"})
public class RunCucumberTest {
}
