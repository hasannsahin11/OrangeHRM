Feature: Verify Disabled Fields on Personal Information Page

  Scenario: Login and Verify Disabled Fields
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    When I navigate to the My Info page
    Then the following fields should be disabled in the Personal Details section:
      | Employee ID        |
      | Driver License No  |
      | Date of Birth      |