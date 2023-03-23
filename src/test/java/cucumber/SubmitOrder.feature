
@tag
Feature: Purchase order from ecommerce
  I want to use this template for my feature file

	Background:
	Given I landed on ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName>  and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name  								| password    |  productName |
      | rahulshetty@gmail.com | IamKing@000 |  ZARA COAT 3 |
      
