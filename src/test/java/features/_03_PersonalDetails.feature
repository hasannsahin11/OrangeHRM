Feature: Verify Disabled Fields on Personal Information Page

  Background:Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

#  Scenario: Login and Verify Disabled Fields
#    When I navigate to the My Info page
#    Then the following fields should be disabled in the Personal Details section:
#      | Employee ID        |
#      | Driver License No  |
#      | Date of Birth      |
#
#  Scenario: Verify Last Name can't be deleted
#    Given I navigate to the My Info page
#    When I delete the value from Last Name field
#    Then "Required" message in red should display under the Last Name field and the change shouldn't be saved
#
#  Scenario: Verify First Name can't be deleted
#    Given I navigate to the My Info page
#    When I delete the value from First Name field
#    Then "Required" message in red should display under the First Name field and the change shouldn't be saved
#
#  Scenario: Update First Name with a Valid Value
#    Given I navigate to the My Info page
#    When I change the First Name field to "Sonia"
#    And I click on the Save button
#    Then the updated first name should be displayed

#  Scenario: Update Nationality with a valid option
#    Given I'm on the My Info page
#    When I update the Nationality to French
#    And I click on the Save button
#    Then The updated Nationality should be successfully saved and displayed
#
#  Scenario: Update Marital Status with a valid option
#    Given I'm on the My Info page
#    When I update the Marital Status to Single
#    And I click on the Save button
#    Then The updated Marital Status should be successfully saved and displayed

    Scenario: Change Gender by using radio button
      Given I'm on the My Info page
      When I click on Male radio button
      And I click on the Save button
      Then The Gender should be successfully saved and displayedChange