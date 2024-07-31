Feature: Checkout

 Scenario Outline: Checkout with valid details

    Given I have logged in and am on the products page with User "<User>"
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my first name "<First Name>", last name "<Last Name>" and postcode "<PostCode>"
    And press the continue button
    And press the finish button
    Then I will be told my order has been dispatched
   Examples:
   |First Name|Last Name |PostCode |User             |
   |Conner    |Humphrey  |B7 4BB   |standard_user    |
   |Conner    |Humphrey  |B7 4BB   |problem_user     |


  Scenario Outline: Checkout with missing First Name

    Given I have logged in and am on the products page with User "<User>"
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my first name "<First Name>", last name "<Last Name>" and postcode "<PostCode>"
    And press the continue button
    Then I will be told I need to enter a first name
    Examples:
      |First Name|Last Name |PostCode |User             |
      |          |Humphrey  |B7 4BB   |standard_user    |
      |          |Humphrey  |B7 4BB   |problem_user     |

  Scenario Outline: Checkout with missing Last Name

    Given I have logged in and am on the products page with User "<User>"
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my first name "<First Name>", last name "<Last Name>" and postcode "<PostCode>"
    And press the continue button
    Then I will be told I need to enter a second name
    Examples:
      |First Name|Last Name |PostCode |User             |
      |Conner    |          |B7 4BB   |standard_user    |
      |Conner    |          |B7 4BB   |problem_user     |

  Scenario Outline: Checkout with missing Post Code

    Given I have logged in and am on the products page with User "<User>"
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my first name "<First Name>", last name "<Last Name>" and postcode "<PostCode>"
    And press the continue button
    Then I will be told I need to enter a Zip code
    Examples:
      |First Name|Last Name |PostCode |User             |
      |Conner    |Humphrey  |         |standard_user    |
      |Conner    |Humphrey  |         |problem_user     |


  Scenario Outline: Checkout with missing fields
    Given I have logged in and am on the products page with User "<User>"
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my first name "<First Name>", last name "<Last Name>" and postcode "<PostCode>"
    And press the continue button
    Then I will be presented with an error code stating "<Expected error code>"
    Examples:
    |First Name|Last Name|PostCode|Expected error code           |User         |
    |Conner    |         |B7 4BB  |Error: Last Name is required  |standard_user|
    |          |Humphrey |B7 4BB  |Error: First Name is required |standard_user|
    |Conner    |Humphrey |        |Error: Postal Code is required|standard_user|
    |          |         |        |Error: First Name is required |standard_user|
    |Conner    |         |B7 4BB  |Error: Last Name is required  |problem_user|
    |          |Humphrey |B7 4BB  |Error: First Name is required |problem_user|
    |Conner    |Humphrey |        |Error: Postal Code is required|problem_user|
    |          |         |        |Error: First Name is required |problem_user|









