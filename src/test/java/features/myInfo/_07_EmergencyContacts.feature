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
    And I fill out the fields besides "Name"
    And I click the Save button
    Then "Required" error message should be displayed under the "Name" field and contact shouldn't be saved

  Scenario Outline: Verify phone number fields Allows numbers and only + - / ( ) characters
    Given I'm on the My Info page
    And I navigate to Emergency Contacts section
    When I click on the Add button
    And I type letters into phone number "<fields>"
    Then "Allows numbers and only + - / ( )" error message should display under the corresponding field

    Examples:
      | fields         |
      | Home Telephone |
      | Mobile         |
      | Work Telephone |

  Scenario Outline: Verify error message displays after exceeding character limits
    Given I'm on the My Info page
    And I navigate to Emergency Contacts section
    When I click on the Add button
    And I enter invalid amount of characters into the following "<field>"
    Then "Should not exceed" message displays under the corresponding field

    Examples:
      | field          |
      | Name           |
      | Relationship   |
      | Home Telephone |
      | Mobile         |
      | Work Telephone |


  Scenario: Verify when updating an Emergency Contact can't be saved after removing phone number
    Given I'm on the My Info page
    And I navigate to Emergency Contacts section
    When I click on the Edit icon of an existing Emergency Contact
    And I remove the phone number
    And I click the Save button
    Then "At least one phone number is required" error message should be displayed under the Home Phone field and the update can't be saved

