
@tag
Feature: Validation of error message after incorrect password or email
  I want to use this template for my feature file



  @ErrorMsg
  Scenario Outline: Validate error message
    Given I land on the ecommerce website
    When Logged in with username "<name>" and password "<password>"
    Then "Incorrect email or password." message is appeared

    Examples: 
      | name  | password |
      | mere@greysloan.com |Merelove244|
     
