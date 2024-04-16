Feature: ESS User Account Creation

  Scenario: Create an ESS User Account as Admin
    Given I am on the OrangeHRM login page
    When I enter the Admin credentials
    And I click the Login button
    And I navigate to the Admin panel
    And I click the Add button
    When I select the necessary options for User role and Status
    And I fill out the necessary fields with:
      | Field            | Value              |
      | Employee Name    | Rosanna Ryan Pagac |
      | Username         | RRPagac7           |
      | Password         | RRPagac7           |
      | Confirm Password | RRPagac7           |
    And I click on the Save button
    Then An ESS user should be successfully created
