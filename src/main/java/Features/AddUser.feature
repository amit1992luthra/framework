Feature: AddUser
  
  @test
  Scenario Outline: 01_Add User with Existing user details
    Given user is already on Login Page
    Then user enters "<username>" and "<password>"
    When user clicks on login button
    And user clicks on Add user button
    And user Add new user with existing user details "<firstname>", "<lastname>" and "<email>"
    Then user again add the same details and verify "user already exists." message
    And Verify "View existing user"link
    Then Click on Edit User button

    Examples: 
      | username    | password     | firstname | lastname | email   |
      | testuser009 | Password@123 | user1     | user     | a@a.com |
      


  Scenario Outline: 01_Click on Save button With Blank mandatory Fields
    Given user is already on Login Page
    Then user enters "<username>" and "<password>"
    And user clicks on login button
    When user is on dashboard
    When user clicks on Add user button
    And user enter first name "<firstname>"
    Then verify save button should be disabled
    When user enter last name "<lastname>"
    Then verify save button should be disabled
    When user enter Email Address "<email>"
    Then verify save button should be disabled
    When user enter Company name
    Then verify save button should be enabled

    Examples: 
      | username    | password     | firstname | lastname | email   |
      | testuser009 | Password@123 | user1     | user     | a@a.com |
