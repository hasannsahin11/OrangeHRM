Feature: Emergency Contacts

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

  Scenario: Add a new Emergency Contact
    Given I'm on the My Info page
    And I navigate to Emergency Contacts section
    When I click on the Add button
    And I fill out the following mandatory fields with the corresponding data:
      | Field         | Value      |
      | Name          | John Doe   |
      | Relationship  | Cousin     |
      | Mobile Number | 3215859999 |
    And I click on the Save button
    Then The new Emergency Contact should be successfully saved and displayed

    Scenario: Verify a new Emergency Contact can't be added without a Name
      Given I'm on the My Info page
      And I navigate to Emergency Contacts section
      When I click on the Add button
      And I fill out the fields beside "Name"
      And I click on the Save button
      Then "Required" error message should be displayed under the "Name" field and contact shouldn't be saved