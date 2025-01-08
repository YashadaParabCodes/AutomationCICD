  @tag
  Feature: Purchase a product from an ecommerce website
  
  Background: 
    Given  I land on the ecommerce website
  
  @Regression
  Scenario Outline: Positive testcase to submit the order
    Given Logged in with username "<name>" and password "<password>"
    When I add productname "<productname>" and click on add to cart
    Then "THANKYOU FOR THE ORDER." confirmation message is displayed

    Examples: 
      | name               | password   | productname     |
      | mere@greysloan.com | Merelove24 | ADIDAS ORIGINAL |
      | gabss@gmail.com    | Gs@123456  | qwerty          |
      
      
   
