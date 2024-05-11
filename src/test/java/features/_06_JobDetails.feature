Feature: Job Details

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

  Scenario: Verify disabled Job Details fields
    Given I'm on the My Info page
    When I navigate to Job Details section
    Then "Joined Date," "Job Title," "Job Specification," "Job Category," "Sub Unit," "Location," and "Employment Status" fields should be displayed and disabled for modification.
