Feature: Update First Name in Personal Information Page

  Background:Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button


  Scenario: Update First Name with a Valid Value
    Given I navigate to the My Info page
    When I change the First Name field to "Sonia"
    And I click on the Save button
    Then the updated first name should be displayed