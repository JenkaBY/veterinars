package io.by.lt.pl.e2e;

import io.by.lt.pl.RouteApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@ActiveProfiles("test")
@CucumberContextConfiguration
public class BootstrapTest {


    @Suite
    @SelectPackages("io.by.lt.pl")
    @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.by.lt.pl")
    @TestPropertySource(locations = "classpath:application-route-service.yaml")
    @SpringBootTest(classes = RouteApplication.class)
    public class RouteApplicationContextConfig {

    }
}
