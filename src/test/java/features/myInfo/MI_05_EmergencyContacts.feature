Feature: Emergency Contacts

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    And I'm on the My Info page

    @Regression
  Scenario: Add a new Emergency Contact
    Given I navigate to Emergency Contacts section
    When I click on the Add button
    And I fill out the following mandatory fields with the corresponding data:
      | Field         | Value      |
      | Name          | John Doe   |
      | Relationship  | Cousin     |
      | Mobile Number | 3215859999 |
    And I click on the Save button
    Then The new Emergency Contact should be successfully saved and displayed

  Scenario: Verify a new Emergency Contact can't be added without a Name
    Given I navigate to Emergency Contacts section
    When I click on the Add button
    And I fill out the fields besides "Name"
    And I click the Save button
    Then "Required" error message should be displayed under the "Name" field and contact shouldn't be saved
#
  Scenario Outline: Verify phone number fields Allows numbers and only + - / ( ) characters
    Given I navigate to Emergency Contacts section
    When I click on the Add button
    And I type letters into phone number "<fields>"
    Then "Allows numbers and only + - / ( )" error message should display under the corresponding field

    Examples:
      | fields         |
      | Home Telephone |
      | Mobile         |
      | Work Telephone |

  Scenario Outline: Verify error message displays after exceeding character limits
    Given I navigate to Emergency Contacts section
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

    @Regression
  Scenario: Edit the existing emergency contact with valid values
    Given I navigate to Emergency Contacts section
    When I click on the Edit icon of an existing Emergency Contact
    And I edit the following fields with corresponding values:
      | Field         | Value      |
      | Name          | Johny Doe  |
      | Relationship  | Friend     |
      | Mobile Number | 7735556677 |
    And I click the Save button
    Then The Emergency Contact should be successfully updated and displayed


  Scenario: Verify when updating an Emergency Contact can't be saved after removing phone number
    Given I navigate to Emergency Contacts section
    When I click on the Edit icon of an existing Emergency Contact
    And I remove the phone number
    And I click the Save button
    Then "At least one phone number is required" error message should be displayed under the Home Phone field and the update can't be saved

    @Regression
Scenario: Delete the existing emergency contact
  Given I navigate to Emergency Contacts section
  When I click on the Delete icon of an existing Emergency Contact
  And I click the Confirm Delete button
  Then The Emergency Contact should be successfully deleted