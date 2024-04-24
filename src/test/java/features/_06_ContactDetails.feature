Feature: Contact Details View and Update

  Background:Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

  Scenario: Update Contact Details with valid information
    Given I'm on the My Info page
    When I click on the Contact Details button
    And I enter a valid street address, city, state, and postal code into the respective fields
    And I enter a valid home, mobile, and work phone numbers into the respective fields
    And I enter a valid work and alternative email addresses into the respective fields
    And I click on the Save button
    Then the contact information should be saved successfully
