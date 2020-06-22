package com.bkteam;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private int a, b;

    @Given("I have {int} and {int}")
    public void i_have_and(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        a = int1; b = int2;
    }


    @When("I add two number")
    public void i_add_two_number() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("The result is {int}")
    public void the_result_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(a + b == int1);
    }
}
