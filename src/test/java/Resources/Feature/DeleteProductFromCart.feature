Feature: Test Delete product from cart function
  Scenario: User Add To Cart successfully
    Given user login successfully
    And click on addtocart button
    And click on cart button
    When click on delete icon
    Then display message