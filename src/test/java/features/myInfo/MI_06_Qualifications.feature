Feature: Qualifications

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    Given I'm on the My Info page

  Scenario: Verify Qualifications Headers
    When I navigate to Qualifications Sections