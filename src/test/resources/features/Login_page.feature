@regression
Feature: SwagLabs Login Page

  @success
  Scenario: Validate successful login
    Given I access website login page
    When I enter a specific correct username standard_user
    And I enter a specific correct password secret_sauce
    And I click on login button
    Then I should be presented with user products page
  @unsuccess
  Scenario: Validate unsuccessful login
    Given I access website login page
    When I enter a wrong username incorrectUsername
    And I enter a wrong password incorrectPassword
    And I click on login button
    Then I should be presented with unsuccessful login message

    @emptyFields
  Scenario: Validate unsuccessful login with an empty both of input fields
    Given I access website login page
    When I enter a blank username
    And I enter a blank password
    And I click on login button
    Then I should be presented with message that input fields are required

    @emptyusernameField
  Scenario: Validate unsuccessful login with an empty username input field
    Given I access website login page
    When I enter a blank username
    And I enter a password someRandomPassword
    And I click on login button
    Then I should be presented with message that input field username is required

    @emptypasswordField
  Scenario: Validate unsuccessful login with an empty password input field
    Given I access website login page
    When I enter a username someRandomUsername
    And I enter a blank password
    And I click on login button
    Then I should be presented with message that input field password is required

    @lockedUser
  Scenario: Validate locked login
    Given I access website login page
    When I enter a username locked_out_user
    And I enter a specific correct password secret_sauce
    And I click on login button
    Then I should be presented with message that account has been locked out

    @multipleUsers
  Scenario Outline: Validate all successful logins
    Given I access website login page
    When I enter a correct username <username>
    And I enter a correct password <password>
    And I click on login button
    Then I should be presented with user products page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |