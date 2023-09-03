Feature:Place a new order after login

  Scenario Outline:Place a new order
    Given I'm on the shop authentication page
    When I login using "johndoe@gmail.com" and "Password123"
    And I'm looking for a product "Hummingbird Printed Sweater"
    And I choose a product
    Then I choose size <size>, quantity <quantity> and add to cart
    And I click on option checkout
    And I choose the address, shipping and payment methods and I agree to the terms
    And Click Place order
    And Take a screenshot with order confirmation and price
    Then I close the browser
    Examples:
    |quantity| size |
    | 10     |    M |