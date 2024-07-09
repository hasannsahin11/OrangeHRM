Feature: Qualifications

  Background: Login with ESS credentials
    Given I am on the OrangeHRM login page
    When I enter the ESS credentials
    And I click the Login button
    Given I'm on the My Info page

#  Scenario: Verify Qualifications Headers
#    Given I navigate to the Qualifications Section
#    When I scroll down to the bottom of the page
#    Then I should see the following Qualification headers:
#      | Work Experience |
#      | Education       |
#      | Skills          |
#      | Languages       |
#      | License         |
#      | Attachments     |
#
#  Scenario: Add a new Work Experience
#    Given I navigate to the Qualifications Section
#    When I click on the Add Work Experience button
#    And I fill in the Company field with "Amazon"
#    And I fill in the Job Title field with "SDET"
#    And I select Start Date as "2020-01-01"
#    And I select End Date as "2022-31-12"
#    And I fill in the Comment field with "Worked on various software development projects"
#    And I click on the Save Work Experience button
#    Then I should see the new Work Experience listed with "Amazon" and "SDET"
#
#  Scenario: Edit an existing Work Experience
#    Given I navigate to the Qualifications Section
#    And I click on the Edit icon of the existing Work Experience
#    And I modify the Company name with "Facebook" and the Job Title field with "QA"
#    When I click on the Save Work Experience button
#    Then I should see the updated Work Experience listed with "Facebook" and "QA"

    Scenario: Delete an existing Work Experience
      Given I navigate to the Qualifications Section
      When I click on the Delete icon of the created Work Experience
      And I click the Confirm Delete button
      Then The Work Experience should be successfully deleted
