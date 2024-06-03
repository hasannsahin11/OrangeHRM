Feature: Qualifications

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    Given I'm on the My Info page

  Scenario: Verify Qualifications Headers
    Given I navigate to Qualifications Sections
    When I scroll down to bottom of the page
    Then I should see below Qualification headers:
      | Work Experience |
      | Education       |
      | Skills          |
      | Languages       |
      | License         |
      | Attachments     |