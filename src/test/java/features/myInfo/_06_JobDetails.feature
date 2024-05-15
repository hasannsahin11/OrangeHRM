Feature: Job Details

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button

#  Scenario: Verify disabled Job Details fields
#    Given I'm on the My Info page
#    When I navigate to Job Details section
#    Then "Joined Date", "Job Title", "Job Specification", "Job Category", "Sub Unit", "Location", and "Employment Status" fields should be displayed and disabled for modification.
#
#  Scenario: User clicks on Include Employment Contract Details switch button
#    Given I'm on the My Info page
#    When I navigate to Job Details section
#    And I toggle the "Include Employment Contract Details" switch to turn it on
#    Then the following fields should be visible but disabled
#      | Contract Start Date |
#      | Contract End Date   |
#      | Contract Details    |

  Scenario: Verify Employment Contract Details Switch State After Page Refresh
    Given I'm on the My Info page
    And I navigate to Job Details section
    When I toggle the "Include Employment Contract Details" switch to turn it on
    And I refresh the page
    Then the Include Employment Contract Details switch should be turned off