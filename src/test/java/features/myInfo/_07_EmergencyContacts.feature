Feature: Emergency Contacts

  Scenario: Add a new Emergency Contact
    Given I'm on the My Info page
    And I navigate to Emergency Contacts section
    When I click the Add button
    And I fill out the necessary fields
    And I click on the Save button
    Then The new Emergency Contact should be successfully saved and displayed