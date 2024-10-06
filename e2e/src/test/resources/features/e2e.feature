Feature: Cucumber test behaviour

  Scenario: Application name should be correct
    Given the e2e module uses spring-boot-test-starter
    Then application name should be "e2e"
