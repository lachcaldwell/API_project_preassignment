Feature: Products page

  Scenario Outline: clicking on a product to go to its page
    Given I have logged in and am on the products page with User "<User>"
    When I click the product with the "<ID>"
    Then I will be navigated to the individual "<Product>" page
    Examples:
    |ID        |Product                          |User             |
    |1         |Sauce Labs Bolt T-Shirt          |standard_user    |
    |2         |Sauce Labs Onesie                |standard_user    |
    |3         |Test.allTheThings() T-Shirt (Red)|standard_user    |
    |4         |Sauce Labs Backpack              |standard_user    |
    |5         |Sauce Labs Fleece Jacket         |standard_user    |
    |0         |Sauce Labs Bike Light            |standard_user    |
    |1         |Sauce Labs Bolt T-Shirt          |problem_user     |
    |2         |Sauce Labs Onesie                |problem_user     |
    |3         |Test.allTheThings() T-Shirt (Red)|problem_user     |
    |4         |Sauce Labs Backpack              |problem_user     |
    |5         |Sauce Labs Fleece Jacket         |problem_user     |
    |0         |Sauce Labs Bike Light            |problem_user     |

    Scenario Outline: Adding individual products to cart
      Given I have logged in and am on the products page with User "<User>"
      When I click the add to cart button for the product with id "<ID>"
      Then The cart iterator will increase by one
      Examples:
      |ID|User         |
      |1 |standard_user|
      |2 |standard_user|
      |3 |standard_user|
      |4 |standard_user|
      |5 |standard_user|
      |6 |standard_user|
      |1 |problem_user |
      |2 |problem_user |
      |3 |problem_user |
      |4 |problem_user |
      |5 |problem_user |
      |6 |problem_user |

    Scenario Outline: Adding all the products to the cart
      Given I have logged in and am on the products page with User "<User>"
      When I click add to cart on all the products
      Then The cart iterator will increase by six
      Examples:
        |User         |
        |standard_user|
        |problem_user |

