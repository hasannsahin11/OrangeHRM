Feature: Verify Disabled Fields on Personal Information Page

#  Background:Login with ESS credentials
#    Given I am on the OrangeHRM login page
#    When I enter the ESS credentials
#    And I click the Login button
#
#  Scenario: Login and Verify Disabled Fields
#    When I navigate to the My Info page
#    Then the following fields should be disabled in the Personal Details section:
#      | Employee ID        |
#      | Driver License No  |
#      | Date of Birth      |
#
#
#  Scenario: Update First Name with a Valid Value
#    Given I navigate to the My Info page
#    When I change the First Name field to "Sonia"
#    And I click on the Save button
#    Then the updated first name should be displayed

  Scenario: Update Nationality and Marital Status with a valid option
    Given I'm on the My Info page
    When I update the Nationality to American and the Marital Status to Single
    And I click on the Save button
    Then Changes should be successfully saved and displayed