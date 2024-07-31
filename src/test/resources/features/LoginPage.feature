Feature: Login

  Scenario Outline: Login with valid details
    Given I am on the login page
    When I enter my valid "<Username>" and "<Password>" into the fields
    And I press the enter button
    Then I will be navigated to the products page
    Examples:
      |Username                 |Password     |
      |standard_user            |secret_sauce |
      |problem_user             |secret_sauce |
      |performance_glitch_user  |secret_sauce |

  Scenario Outline: Login with locked out user
    Given I am on the login page
    When I enter the details of a locked account "<Username>" "<Password>"
    And I press the enter button
    Then I will be told my account is locked out with an "<Error Message>"
    Examples:
      |Username                 |Password     | Error Message|
      |locked_out_user          |secret_sauce |Epic sadface: Sorry, this user has been locked out.|

  Scenario Outline: Login with invalid details
    Given I am on the login page
    When I enter an invalid "<Username>" and "<Password>" into the fields
    And I press the enter button
    Then I will not be logged in with and "<Error Message>"
    Examples:
      |Username                 |Password     |Error Message                                                            |
      |NotAUSer                 |password     |Epic sadface: Username and password do not match any user in this service|
      |                         |password     |Epic sadface: Username is required                                       |
      |username                 |             |Epic sadface: Password is required                                       |
      |123                      |123          |Epic sadface: Username and password do not match any user in this service|
      |                         |             |Epic sadface: Username is required                                       |