Feature: Login to OrangeHRM ESS

  @Smoke
  Scenario: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    Then I should see the Dashboard page displayed

    @Regression
  Scenario Outline: Login with Invalid Credentials
    Given I am on the OrangeHRM login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click the Login button
    Then I should see an error message

    Examples:
      | username | password  |
#  both invalid username & password
      | GButlers | 7Sbhaheen7 |
#  valid un invalid pass
      | SShaheen11 | JButlers  |
#  invalid un valid pass
      | GButlers | SShaheen11  |