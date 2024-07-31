Feature: Cart page

  Scenario Outline: Adding one item to cart
    Given I have logged in and am on the products page with User "<User>"
    When I click the add to cart button for the product with id "<ID>"
    And I click the cart button
    Then The item with the link id "<Link ID>" and name "<Name>" will be displayed in the cart
    Examples:
        |ID|Link ID|Name                            |User          |
        |1 |4      |Sauce Labs Backpack               |standard_user |
        |2 |0      |Sauce Labs Bike Light             |standard_user |
        |3 |1      |Sauce Labs Bolt T-Shirt           |standard_user |
        |4 |5      |Sauce Labs Fleece Jacket          |standard_user |
        |5 |2      |Sauce Labs Onesie                 |standard_user |
        |6 |3      |Test.allTheThings() T-Shirt (Red) |standard_user |
        |1 |4      |Sauce Labs Backpack               |problem_user |
        |2 |0      |Sauce Labs Bike Light             |problem_user |
        |3 |1      |Sauce Labs Bolt T-Shirt           |problem_user |
        |4 |5      |Sauce Labs Fleece Jacket          |problem_user |
        |5 |2      |Sauce Labs Onesie                 |problem_user |
        |6 |3      |Test.allTheThings() T-Shirt (Red) |problem_user |

