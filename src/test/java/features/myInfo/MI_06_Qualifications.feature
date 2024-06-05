Feature: Qualifications

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    Given I'm on the My Info page

  Scenario: Verify Qualifications Headers
    Given I navigate to the Qualifications Section
    When I scroll down to the bottom of the page
    Then I should see the following Qualification headers:
      | Work Experience |
      | Education       |
      | Skills          |
      | Languages       |
      | License         |
      | Attachments     |