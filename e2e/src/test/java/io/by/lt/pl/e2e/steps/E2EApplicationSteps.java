package io.by.lt.pl.e2e.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


public class E2EApplicationSteps {

    @Autowired
    private ApplicationContext ctx;

    @Given("the e2e module uses spring-boot-test-starter")
    public void theEEModuleUsesSpringBootTestStarter() {
        assertThat(true).isTrue();
    }

    @Then("application name should be {string}")
    public void applicationNameShouldBe(String expectedApplicationName) {
        var actual = ctx.getEnvironment().getProperty("spring.application.name");

        assertThat(actual).isEqualTo(expectedApplicationName);
    }
}
