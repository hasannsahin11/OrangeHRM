Feature: Upload Profile Picture

  Background:Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

  Scenario: Upload a Profile Picture
    Given I'm on the My Info page
    When I click on the photograph displayed at the top left corner of the page
    And I click on the Choose a File button
    And I select a JPG image file that is less than One MB
    And I click on the Save button
    Then the profile picture should be successfully uploaded and displayed