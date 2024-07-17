Feature: Contact Details View and Update

  Background:Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

@Regression
  Scenario: Verify existing email address displayed
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    Then "sania1@osohrm.com" should be displayed in the Work Email field


  Scenario: Update Contact Details with valid information
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    And I enter a valid street address, city, state, and postal code into the respective fields
    And I enter a valid home, mobile, and work phone numbers into the respective fields
    And I enter a valid alternative email address into the respective field
    And I click on the Save button
    Then the contact information should be saved and displayed successfully
#
  Scenario: Verify Contact Details displayed accurately
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    Then the updated contact information should be displayed accurately


  Scenario: Verify Contact Details deleted
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    And I remove all the contact details
    And I click on the Save button
    Then the changes should be saved and there is no contact information displayed


  Scenario: Verify that the address, zipcode, phone number, and email fields have the correct character limits.
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    And Enter an address with more than "70" characters.
    And Enter a zipcode with more than "10" characters.
    And Enter a home phone number with more than "25" characters.
    And Enter an email address with more than "50" characters.
    Then The system should prevent the user from entering more than required amounts and display a red error message under each field

  Scenario: Verify new Work Email Address added
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    And I enter a new Work Email address
    Then The new email address successfully saved and displayed


  Scenario: Verify same email address can't be added as the Other Email
    Given I'm on the My Info page
    When I navigate to the Contact Details page
    And I enter same Work Email address into the Other Email field
    Then "Already exists" message displays in red under the corresponding field
    Then "Work Email and Other Email cannot be the same" message displays under existing Work Email address' field once I click save


