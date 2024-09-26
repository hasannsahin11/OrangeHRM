Feature: Upload Profile Picture

  Background:Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button


  Scenario: Upload a Profile Picture in JPG format
    Given I'm on the My Info page
    When I click on the photograph displayed at the top left corner of the page
    And I click on the Choose a File button
    And I select a JPG image file that is less than One MB
    And I click on the Save button
    Then the profile picture should be successfully uploaded and displayed


  Scenario: Upload a Profile Picture in PNG format
    Given I'm on the My Info page
    When I click on the photograph displayed at the top left corner of the page
    And I click on the Choose a File button
    And I select a PNG image file that is less than One MB
    And I click on the Save button
    Then the profile picture should be successfully uploaded and displayed


  Scenario: Upload a Profile Picture in an Invalid format (.exe)
    Given I'm on the My Info page
    When I click on the photograph displayed at the top left corner of the page
    And I click on the Choose a File button
    And I select an Invalid .exe file that is less than One MB
    Then a "File type not allowed" message should be displayed, and the profile picture shouldn't be updated


  Scenario: Upload a Profile Picture over 1MB
    Given I'm on the My Info page
    When I click on the photograph displayed at the top left corner of the page
    And I click on the Choose a File button
    And I select a PNG image file that is more than One MB
    Then a "Attachment Size Exceeded" message should be displayed and the profile picture shouldn't be updated