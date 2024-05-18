Feature: Emergency Contacts

  Scenario: Add a new Emergency Contact
    Given I'm on the My Info page
    And I navigate to Emergency Contacts section
    When I click the Add button
    And I fill out the necessary fields with the following data:
      | Name          | John Doe   |
      | Relationship  | Cousin     |
      | Mobile Number | 3215859999 |
    And I click on the Save button
    Then The new Emergency Contact should be successfully saved and displayed